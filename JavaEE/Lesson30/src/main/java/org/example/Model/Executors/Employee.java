package org.example.Model.Executors;

import lombok.Builder;
import org.example.Model.State;

@Builder
public class Employee implements Executor {
    State state;
    @Override
    public boolean execute() {
        if (state == State.VACATION) {
            System.out.println("No, i'm on the vacation");
            return false;
        }
        if (state == State.WEEKEND) {
            System.out.println("No, today is weekend day");
            return false;
        }
        if (state == State.SICK) {
            System.out.println("No, i'm sick");
            return false;
        }
        if (state == State.WORK) {
            System.out.println("Let's do this");
            return true;
        }
        return false;
    }
}
