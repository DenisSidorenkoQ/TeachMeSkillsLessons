package org.example.Model.State;

public class RestState implements OrganizationMemberState {
    @Override
    public void printState() {
        System.out.println("I am rest");
    }

    @Override
    public boolean getState() {
        return false;
    }
}
