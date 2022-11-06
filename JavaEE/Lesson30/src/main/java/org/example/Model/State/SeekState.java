package org.example.Model.State;

import org.example.Model.OrganizationMember;

import java.util.List;

public class SeekState implements OrganizationMemberState {
    @Override
    public boolean executeTask(OrganizationMember organizationMember, String task) {
        return false;
    }
}
