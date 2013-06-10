=begin

Copyright 2012-2013 inBloom, Inc. and its affiliates.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

=end

require "selenium-webdriver"
require 'json'
require 'mongo'
require 'rest-client'

require_relative '../../../utils/sli_utils.rb'
require_relative '../../../utils/selenium_common.rb'

#############################################################################################
# OAUTH Steps
#############################################################################################

Given /^the testing device app key has been created$/ do
  @oauthClientId = "EGbI4LaLaL"
  @oauthClientSecret = "iGdeAGCugi4VwZNtMJR062nNKjB7gRKUjSB0AcZqpn8Beeee"
  @oauthRedirectURI = "http://device"
end

When /^I navigate to the API authorization endpoint with my client ID$/ do
  @driver.get PropLoader.getProps['api_server_url'] + "/api/oauth/authorize?response_type=code&client_id=#{@oauthClientId}"
end

Then /^I should be redirected to the realm choosing page$/ do
  assertWithWait("Failed to navigate to Realm chooser") {@driver.title.index("Choose your realm") != nil}
end

When /^I select "(.*?)" from the dropdown and click go$/ do |arg1|
  select = Selenium::WebDriver::Support::Select.new(@driver.find_element(:tag_name, "select"))
  select.select_by(:text, arg1)
  assertWithWait("Could not find the Go button")  { @driver.find_element(:id, "go") }
  @driver.find_element(:id, "go").click
end

Then /^I should receive a json response containing my authorization code$/ do
  assertWithWait("Could not find text 'authorization_code' on page") {@driver.page_source.include?("authorization_code")}
  @oauthAuthCode = @driver.page_source.match(/"authorization_code":"(?<Code>[^"]*)"/)[:Code]
end

Then /^I should receive a response page with http error code 403$/ do
  assertWithWait("Could not find text 'HTTP Error 403' on page") {@driver.page_source.include?("HTTP Error 403")}
end

When /^I navigate to the API token endpoint with my client ID, secret, authorization code, and redirect URI$/ do
  @driver.get PropLoader.getProps['api_server_url'] + "/api/oauth/token?response_type=code&client_id=#{@oauthClientId}" +
  "&client_secret=#{@oauthClientSecret}&code=#{@oauthAuthCode}&redirect_uri=#{@oauthRedirectURI}"
end

Then /^I should receive a json response containing my authorization token$/ do
  assertWithWait("Could not find text 'authorization_token' on page") {@driver.page_source.include?("access_token")}

  @sessionId = @driver.page_source.match(/"access_token":"(?<Token>[^"]*)"/)[:Token]
  puts "sessionId = #@sessionId"
end

Then /^I should be able to use the token to make valid API calls$/ do
  restHttpGet("/system/session/check", "application/json")
  assert(@res != nil, "Response from rest-client GET is nil")
  assert(@res != nil, "Response is nil")
  data = JSON.parse(@res.body)
  assert(data != nil, "Response body is nil")
  assert(data['authenticated'] == true,
  "Session debug context 'authentication.authenticated' is not true")
end

#############################################################################################


#############################################################################################
# Database Steps
#############################################################################################

When /^the SEOAAs have been updated in the database$/ do
  conn = Mongo::Connection.new(PropLoader.getProps['DB_HOST'], PropLoader.getProps['DB_PORT'])
  tenantName = 'Midgar'
  dbTenant = conn.db(convertTenantIdToDbName(tenantName))
  staffColl = dbTenant.collection("staff")
  cgrayId = staffColl.find_one({"body.staffUniqueStateId" => "cgray"})["_id"]
  rbravermanId = staffColl.find_one({"body.staffUniqueStateId" => "rbraverman"})["_id"]
  seoaaColl = dbTenant.collection("staffEducationOrganizationAssociation")
  seoaaColl.update({"body.staffReference" => cgrayId}, {"$set" => {"body.endDate" => "2008-07-07"}}, {:multi => true})
  seoaaColl.update({"body.staffReference" => rbravermanId}, {"$set" => {"body.staffClassification" => "Janitor"}}, {:multi => true})
end

#############################################################################################


#############################################################################################
# API Steps
#############################################################################################

Then /^I should get and store the link named "(.*?)"$/ do |mylink|
  @result = JSON.parse(@res.body)
  assert(@result != nil, "Response contains no data")
  found = false
  if !@result.nil? && !@result.empty?
    @result["links"].each do |link|
      if link["rel"] == mylink
        found = true
        teacherHashPush(mylink, link["href"])
      end
    end
  end
  assert(found, "Could not find the link #{mylink} in the URI Response: #{@result}")
end

Then /^I should extract the "(.*?)" id from the "(.*?)" URI$/ do |resource, link|
  value = @teacher[link].match(/#{resource}\/(.*?_id)/)
  teacherHashPush("id", $1)
end


#############################################################################################

# Build the teacher hash
def teacherHashPush(key, value)
  @teacher = Hash.new unless defined? @teacher
  @teacher[key] = value
end
