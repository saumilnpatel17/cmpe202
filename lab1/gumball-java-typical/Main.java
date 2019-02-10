import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\u000C");

        String toContinue = "";
        Scanner reader = new Scanner(System.in);
        int chosenGumballMachine = 0;

        do
        {
            System.out.println("There are three Gumball Machines.");
            System.out.println("1. Gumball Machine which costs 25 cents and accepts only Quarters\n2. Gumball Machine which costs 50 cents and accepts Two Quarters\n3. Gumball Machine which costs 50 cents and accepts all coins (i.e. nickels, dimes and quarters)");
            System.out.print("Enter 1, 2 or 3 to choose which Gumball Machine would you like to play? : ");

            if(reader.hasNextInt())
            {
                chosenGumballMachine = reader.nextInt();

                switch(chosenGumballMachine)
                {
                    case 1:
                    GumballMachine gumballMachineOnlyQuarters = new GumballMachine(5, 25);
                    gumballMachineOnlyQuarters.insertCoin(true);
                    gumballMachineOnlyQuarters.turnCrank();
                    break;

                    case 2:
                    GumballMachine gumballMachineTwoQuarters = new GumballMachine(5, 50);
                    gumballMachineTwoQuarters.insertCoin(true);
                    gumballMachineTwoQuarters.turnCrank();
                    break;

                    case 3:
                    GumballMachine gumballMachineAllCoins = new GumballMachine(5, 50);
                    gumballMachineAllCoins.insertCoin(false);
                    gumballMachineAllCoins.turnCrank();
                    break;

                    default:
                    System.out.println("Please choose valid Gumball Machine");
                    break;
                }
            }
            else
            {
                System.out.println("Please choose valid Gumball Machine");
                reader.nextLine();
            }

            System.out.print("Do you wish to continue (Press Y for Yes and N for No) Y/N ? ");
            toContinue = reader.next();
        }
        while(toContinue.equalsIgnoreCase("y"));
    }
}
