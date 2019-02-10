import java.util.Scanner;
import java.util.InputMismatchException;

public class GumballMachine
{

    private int num_gumballs;
    private int cost;
    private int totalCoinsInserted;
    private boolean hasEnoughCoins;

    public GumballMachine( int size, int amount )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.cost = amount;
        this.totalCoinsInserted = 0;
        this.hasEnoughCoins = false;
    }

    // public void insertQuarter(int coin)
    // {
    // if ( coin == 25 )
    // this.has_quarter = true ;
    // else 
    // this.has_quarter = false ;
    // }

    public void turnCrank()
    {
        if ( this.hasEnoughCoins )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                this.hasEnoughCoins = false ;
                System.out.println( "Thank you.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
            }
        }
        else 
        {
            System.out.println( "There are not sufficient coins to release a gumball" ) ;
        }        
    }

    public void insertCoin(boolean onlyAcceptQuarters)
    {
        Scanner reader = new Scanner(System.in);
        String toContinue = "";
        int coin = 0;
        do
        {
            System.out.print("Please Insert a coin : ");
            if(reader.hasNextInt())
            {
                if(onlyAcceptQuarters)
                {
                    if(reader.nextInt() == 25)
                    {
                        totalCoinsInserted += 25;
                    }
                    else
                    {
                        System.out.println("This Gumball Machine only accepts QUARTERS");
                    }
                }
                else
                {
                    coin = reader.nextInt();
                    if(coin == 5 || coin == 10 || coin == 25)
                    {
                        totalCoinsInserted += coin;
                    }
                    else
                    {
                        System.out.println("This Gumball Machine accepts NICKELS, DIMES & QUARTERS");
                    }
                }
            }
            else
            {
                System.out.println("Please insert a valid coin");
                reader.nextLine();
            }

            if(totalCoinsInserted >= cost)
            {
                hasEnoughCoins = true;
            }
            System.out.print("Do you wish to continue (Press Y for Yes and N for No) Y/N ? ");
            toContinue = reader.next();
        }
        while(toContinue.equalsIgnoreCase("Y"));
    }
}
