import java.util.Scanner;
import java.util.ArrayList;

public class GumballMachine {

    State soldOutState;
    State noCoinState;
    State hasCoinState;
    State soldState;
    State waitingForCoinState;

    State state = soldOutState;
    int count = 0;
    int cost = 0;
    int totalCoinsInserted = 0;
    boolean acceptOnlyQuarters = false;
    ArrayList<Integer> coinsInserted = new ArrayList<Integer>();

    public GumballMachine(int numberGumballs, int cost, boolean acceptOnlyQuarters) {
        soldOutState = new SoldOutState(this);
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        waitingForCoinState = new WaitingForCoinState(this);

        this.cost = cost;
        this.acceptOnlyQuarters = acceptOnlyQuarters;

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noCoinState;
        } 
    }

    public void start()
    {
        Scanner reader = new Scanner(System.in);
        int chosenOption = 0;
        
        do
        {
            System.out.print("Press '1' To Insert a coin, '2' To Eject a coin, '3' To Turn Crank or press any other key to EXIT : ");
            if(reader.hasNextInt())
            {
                chosenOption = reader.nextInt();
                switch (chosenOption)
                {
                    case 1:
                    this.insertCoin();
                    break;
                    case 2:
                    this.ejectCoin();
                    break;
                    case 3:
                    this.turnCrank();
                    break;
                    default:
                    System.out.println("Thank you. Bye");
                    break;
                }
            }
            else
            {
                System.out.println("Thank you for using this Gumball. GoodBye");
                chosenOption = 0;
                reader.nextLine();
            }
        }while(chosenOption == 1 || chosenOption == 2 || chosenOption == 3);

    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count = count;
        state = noCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWaitingForCoinState() {
        return waitingForCoinState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
