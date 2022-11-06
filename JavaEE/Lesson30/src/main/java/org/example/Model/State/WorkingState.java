package org.example.Model.State;

import org.example.Model.OrganizationMember;

public class WorkingState implements OrganizationMemberState {
    @Override
    public boolean executeTask(OrganizationMember organizationMember, String task) {
        System.out.println("Я работаю, задача сделана");
        return organizationMember.executeTask(task);
    }
}
