package org.example.Model.State;

import org.example.Model.OrganizationMember;

public class HolidayState implements OrganizationMemberState {
    @Override
    public boolean executeTask(OrganizationMember organizationMember, String task) {
        return false;
    }
}
