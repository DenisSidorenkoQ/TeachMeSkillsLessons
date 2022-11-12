package org.example.Model.State;

import org.example.Model.OrganizationMember;

public interface OrganizationMemberState {
    boolean executeTask(OrganizationMember organizationMember, String task);
}
