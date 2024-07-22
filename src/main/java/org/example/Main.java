package org.example;

public class Main {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5,2);
        gumballMachine.insertQuarter();
        gumballMachine.choose("Mango");
        gumballMachine.choose("Orange");
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.choose("Mango");
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.choose("Mango");
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.choose("Mango");
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.choose("Mango");
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.choose("Orange");
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.choose("Orange");
        gumballMachine.turnCrank();
    }
}