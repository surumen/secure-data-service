<GradeIdentity>
    <StudentSectionAssociationReference>
        <StudentSectionAssociationIdentity>
            <StudentIdentity>
                <StudentUniqueStateId>${Grade.StudentSectionAssociationReference.StudentSectionAssociationIdentity.StudentIdentity.StudentUniqueStateId}</StudentUniqueStateId>
            </StudentIdentity>
            <SectionIdentity>
                    <StateOrganizationId>${Grade.StudentSectionAssociationReference.StudentSectionAssociationIdentity.SectionIdentity.StateOrganizationId}</StateOrganizationId>
                    <UniqueSectionCode>${Grade.StudentSectionAssociationReference.StudentSectionAssociationIdentity.SectionIdentity.UniqueSectionCode}</UniqueSectionCode>
            </SectionIdentity>
        </StudentSectionAssociationIdentity>
    </StudentSectionAssociationReference>
    <GradingPeriodReference>
        <GradingPeriodIdentity>
            <GradingPeriod>${Grade.GradingPeriodReference.GradingPeriodIdentity.GradingPeriod}</GradingPeriod>
            <SchoolYear>${Grade.GradingPeriodReference.GradingPeriodIdentity.SchoolYear}</SchoolYear>
             <StateOrganizationId>${Grade.GradingPeriodReference.GradingPeriodIdentity.StateOrganizationId}</StateOrganizationId>
        </GradingPeriodIdentity>
    </GradingPeriodReference>
</GradeIdentity>
