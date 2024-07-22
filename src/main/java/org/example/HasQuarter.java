package org.example;

import java.util.Random;

public class HasQuarter implements State {
    Random random = new Random();
    GumballMachine gumballMachine;

    public HasQuarter(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarter());
    }

    public void turnCrank() {
        System.out.println("You turned...");
        int winner = random.nextInt(10);
        if ((winner == 5) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinner());
        } else {
            gumballMachine.setState(gumballMachine.getSold());
        }
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}