package org.example.Model.State;

public class HolidayState implements OrganizationMemberState {

    @Override
    public void printState() {
        System.out.println("I'm on holiday");
    }

    @Override
    public boolean getState() {
        return false;
    }
}
