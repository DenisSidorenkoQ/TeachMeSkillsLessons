package org.example.Model.State;

import org.example.Model.OrganizationMember;

public class SeekState implements OrganizationMemberState {
    @Override
    public boolean executeTask(OrganizationMember organizationMember, String task) {
        System.out.println("Я болею, задача не сделана");
        return false;
    }
}
