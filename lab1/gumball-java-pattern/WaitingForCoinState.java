/**
 * Write a description of class WaitingForCoinState here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class WaitingForCoinState implements State
{
    GumballMachine gumballMachine;
    int insertedCoin = 0;

    public WaitingForCoinState(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }

    public void insertCoin()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Please insert a coin : ");
        if(reader.hasNextInt())
        {
            if(gumballMachine.acceptOnlyQuarters)
            {
                if(reader.nextInt() == 25)
                {
                    insertedCoin = 25;
                    gumballMachine.totalCoinsInserted += insertedCoin;

                    if(gumballMachine.totalCoinsInserted >= gumballMachine.cost)
                    {
                        gumballMachine.setState(gumballMachine.getHasCoinState());
                        gumballMachine.coinsInserted.add(insertedCoin);
                    }
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
                    gumballMachine.totalCoinsInserted += insertedCoin;
                    gumballMachine.coinsInserted.add(insertedCoin);

                    if(gumballMachine.totalCoinsInserted >= gumballMachine.cost)
                    {
                        gumballMachine.setState(gumballMachine.getHasCoinState());
                    }
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
    }

    public void ejectCoin()
    {
        if(gumballMachine.coinsInserted.size() > 0)
        {
            gumballMachine.totalCoinsInserted -= gumballMachine.coinsInserted.get(0);
            gumballMachine.coinsInserted.remove(0);
            System.out.println("Coin returned");

            if(gumballMachine.coinsInserted.size() == 0)
            {
                gumballMachine.setState(gumballMachine.getNoCoinState());
            }
        }
        else
        {
            gumballMachine.setState(gumballMachine.getNoCoinState());
        }
    }

    public void turnCrank()
    {
        System.out.println("You turned, but you haven't inserted enough Coins to roll out a gumball");
    }

    public void dispense()
    {
        System.out.println("You need to pay full amount first");
    }

    public String toString()
    {
        return "waiting for Coin";
    }

}
