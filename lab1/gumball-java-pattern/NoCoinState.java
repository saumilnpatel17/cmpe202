import java.util.Scanner;

public class NoCoinState implements State {
    GumballMachine gumballMachine;
    int insertedCoin = 0;
    
    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertCoin() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Please insert a coin : ");

        if(reader.hasNextInt())
        {
            if(gumballMachine.acceptOnlyQuarters)
            {
                if(reader.nextInt() == 25)
                {
                    insertedCoin = 25;
                    if(gumballMachine.cost == insertedCoin)
                    {
                        gumballMachine.setState(gumballMachine.getHasCoinState());
                    }
                    else
                    {
                        gumballMachine.totalCoinsInserted = insertedCoin;
                        gumballMachine.setState(gumballMachine.getWaitingForCoinState());
                    }
                    gumballMachine.coinsInserted.add(insertedCoin);
                }
                else
                {
                    System.out.println("This Gumball Machine only accepts QUARTERS");
                }
            }
            else
            {
                insertedCoin = reader.nextInt();
                if(insertedCoin == 5 || insertedCoin == 10 || insertedCoin == 25)
                {
                    gumballMachine.totalCoinsInserted = insertedCoin;
                    gumballMachine.coinsInserted.add(insertedCoin);
                    gumballMachine.setState(gumballMachine.getWaitingForCoinState());
                }
                else
                {
                    insertedCoin = 0;
                    System.out.println("This Gumball Machine only accepts NICKELS, DIMES & QUARTERS");
                }
            }
        }
        else
        {
            System.out.println("Please insert a valid coin");
            reader.nextLine();
        }
        // System.out.println("You inserted a Coin");
        // gumballMachine.setState(gumballMachine.getWaitingForCoinState());
    }

    public void ejectCoin() {
        System.out.println("There is no coin to return");
    }

    public void turnCrank() {
        System.out.println("You turned, but there's no Coin");
    }

    public void dispense() {
        System.out.println("You need to pay first");
    } 

    public String toString() {
        return "waiting for Coin";
    }
}
