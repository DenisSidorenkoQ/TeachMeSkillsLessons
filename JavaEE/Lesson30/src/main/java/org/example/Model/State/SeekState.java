package org.example.Model.State;

public class SeekState implements OrganizationMemberState {
    @Override
    public void printState() {
        System.out.println("I am seek");
    }

    @Override
    public boolean getState() {
        return false;
    }
}
