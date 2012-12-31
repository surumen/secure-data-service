
=begin

Copyright 2012 Shared Learning Collaborative, LLC

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

require 'timeout'

require_relative 'spec_helper'
require_relative '../lib/WorldDefinition/section_work_order'

# specifications for the section work order factory
describe "SectionWorkOrderFactory" do
  describe "request to create sections --> with a simple edorg and scenario" do

    before(:all) do
      config = YAML.load_file(File.join(File.dirname(__FILE__),'../config.yml'))
      scenario = {'STUDENTS_PER_SECTION' => {'high' => 10}, 'MAX_SECTIONS_PER_TEACHER' => {'high' => 5},
        'GRADEBOOK_ENTRIES_BY_GRADE' => {
          "Ninth grade" => { "Homework" => {"min" => 1, "max" => 4} },
          "Tenth grade" => { "Homework" => {"min" => 1, "max" => 4} }
        }
      }
      
      offerings = [{'id' => 1, 'grade' => :NINTH_GRADE, 'ed_org_id'=>'high-0000000042'}, 
        {'id' => 2, 'grade' => :TENTH_GRADE, 'ed_org_id'=>'high-0000000042'}, 
        {'id' => 3, 'grade' => :TENTH_GRADE, 'ed_org_id'=>'high-0000000042'}]
      
      @ed_org = {'id' => 42, 'students' => {2001 => {:NINTH_GRADE => 30, :TENTH_GRADE => 0}, 2002 => {:NINTH_GRADE => 0, :TENTH_GRADE => 30}},
                             'offerings' => {2001 => offerings, 2002 => offerings},
                             'teachers' => []}
      
      world = { "high" => [@ed_org] }
      prng = Random.new(config['seed'])
      @factory = SectionWorkOrderFactory.new(world, scenario, prng)
      @factory.generate_sections_with_teachers(@ed_org, "high")
    end

    after(:all) do
      @factory = nil
    end

    it "will return enough sections so that each student can take it" do
      ninth_grade_sections = @factory.sections(@ed_org['id'], "high", 2001, :NINTH_GRADE)
      ninth_grade_sections[1].count.should eq 3
      
      tenth_grade_sections = @factory.sections(@ed_org['id'], 'high', 2002, :TENTH_GRADE)
      tenth_grade_sections[2].count.should eq 3
      tenth_grade_sections[3].count.should eq 3
    end

    it "will return no sections when there are no available students" do
      ninth_grade_sections = @factory.sections(@ed_org['id'], 'high', 2002, :NINTH_GRADE)
      ninth_grade_sections.should be_empty
      
      tenth_grade_sections = @factory.sections(@ed_org['id'], 'high', 2001, :TENTH_GRADE)
      tenth_grade_sections.should be_empty
    end

  end
end
