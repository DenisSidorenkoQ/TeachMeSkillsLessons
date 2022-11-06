package org.example.Model.Manager;

import lombok.Builder;
import org.example.Model.OrganizationMember;
import org.example.Model.State.OrganizationMemberState;
import org.example.Model.State.SeekState;

import java.util.List;

@Builder
public class Administrator implements OrganizationMember {
    private List<OrganizationMember> organizationMemberList;
    private OrganizationMemberState organizationMemberState;

    @Override
    public boolean executeTask(String task) {
        if (organizationMemberState.getState()) {
            for (OrganizationMember member : organizationMemberList) {
                if (member.executeTask(task)) {
                    return true;
                }
            }
        } else {
            organizationMemberState.printState();
        }
        return false;
    }
}
