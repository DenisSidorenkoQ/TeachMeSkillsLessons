package org.example.Model.Executors;

public class Contractor extends Employee {
    @Override
    public boolean execute() {
        System.out.println("Let's do this");
        return true;
    }
}
