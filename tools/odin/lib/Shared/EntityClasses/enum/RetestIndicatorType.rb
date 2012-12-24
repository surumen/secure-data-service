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

require_relative 'Enum.rb'

# Enumerates the types of retest indicators. From Ed-Fi-Core.xsd:
# <xs:simpleType name="RetestIndicatorType">
#   <xs:annotation>
#     <xs:documentation>Indicator if the test was retaken.  For example:
#     Primary administration
#     First retest
#     Second retest
#     ...
#     </xs:documentation>
#   </xs:annotation>
#   <xs:restriction base="xs:token">
#     <xs:enumeration value="Primary Administration"/>
#     <xs:enumeration value="1st Retest"/>
#     <xs:enumeration value="2nd Retest"/>
#   </xs:restriction>
# </xs:simpleType>
class RetestIndicatorType
  include Enum

  RetestIndicatorType.define :FIRST_RETEST, "1st Retest"
  RetestIndicatorType.define :PRIMARY_ADMINISTRATION, "Primary Administration"
  RetestIndicatorType.define :SECOND_RETEST, "2nd Retest"
end
