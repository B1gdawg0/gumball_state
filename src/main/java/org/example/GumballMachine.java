package org.example;

public class GumballMachine {

    State soldOut;
    State noQuarter;
    State hasQuarter;
    State sold;
    State winner;
    final int ORANGE = 0;
    final int MANGO = 1;
    final int NOTCHOOSE = -1;

    State state = soldOut;
    int count = 0;
    int orange = 0;
    int mango = 0;
    int currentColor = NOTCHOOSE;

    public GumballMachine(int numberGumballs, int orange) {
        this.soldOut = new SoldOut(this);
        this.noQuarter = new NoQuarter(this);
        this.hasQuarter = new HasQuarter(this);
        this.sold = new Sold(this);
        this.winner = new Winner(this);

        this.count = numberGumballs;
        this.orange = orange;
        this.mango = count-orange;

        System.out.println(count+" "+orange+" "+mango);
        if (numberGumballs > 0) {
            state = noQuarter;
        }
    }

    public void choose(String color){
        currentColor = (color.equalsIgnoreCase("orange"))?ORANGE:MANGO;
        System.out.println("You have chosen the flavor "+((currentColor == ORANGE)?"Orange":"Mango"));
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        if(currentColor == NOTCHOOSE){
            System.out.println("You have to choose the flavor first\n" +
                    "No gumball dispensed");
            return;
        }
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        if(currentColor == NOTCHOOSE){
            System.out.println("You have to choose the flavor first\n" +
                    "No gumball dispensed");
            return;
        }
        if (count > 0) {
            if ((currentColor == ORANGE)) {
                if(orange > 0) {
                    --orange;
                    --count;
                }
                else {
                    System.out.println("oops! no orange gumball left");
                    return;
                }
            } else if(currentColor == MANGO){
                if(mango > 0) {
                    --mango;
                    --count;
                }
                else{
                    System.out.println("oops! no mango gumball left");
                    return;
                }

            }
        }
        System.out.println("A"+((currentColor == ORANGE)?" Orange ":" Mango ")+"gumball comes rolling out the slot");
    }

    int getCount() {
        return count;
    }

    public State getSoldOut() {
        return soldOut;
    }

    public State getNoQuarter() {
        return noQuarter;
    }

    public State getHasQuarter() {
        return hasQuarter;
    }

    public State getSold() {
        return sold;
    }

    public State getWinner() {
        return winner;
    }

}