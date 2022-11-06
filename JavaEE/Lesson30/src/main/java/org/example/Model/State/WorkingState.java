package org.example.Model.State;

public class WorkingState implements OrganizationMemberState {

    @Override
    public void printState() {
        System.out.println("Ready for work");
    }

    @Override
    public boolean getState() {
        return true;
    }
}
