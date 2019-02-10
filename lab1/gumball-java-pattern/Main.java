import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\u000c");

        int chosenGumballMachine = 0;
        Scanner reader = new Scanner(System.in);
        String toContinue = "";

        do
        {
            System.out.println("There are three Gumball Machines.");
            System.out.println("1. Gumball Machine which costs 25 cents and accepts only QUARTERS");
            System.out.println("2. Gumball Machine which costs 50 cents and aceepts only QUARTERS");
            System.out.println("3. Gumball Machine which costs 50 cents and accepts all coins (i.e. NICKELS, DIMES & QUARTERS");
            System.out.print("Enter 1,2 or 3 to choose which Gumball Machine would you like to play? ");

            if(reader.hasNextInt())
            {
                chosenGumballMachine = reader.nextInt();

                switch(chosenGumballMachine)
                {
                    case 1:
                    GumballMachine gumballMachineOnlyQuarter = new GumballMachine(5, 25, true);
                    System.out.println(gumballMachineOnlyQuarter);
                    gumballMachineOnlyQuarter.start();
                    break;
                    case 2:
                    GumballMachine gumballMachineTwoQuarters = new GumballMachine(5, 50, true);
                    System.out.println(gumballMachineTwoQuarters);
                    gumballMachineTwoQuarters.start();
                    break;
                    case 3:
                    GumballMachine gumballMachineAllCoins = new GumballMachine(5, 50, false);
                    System.out.println(gumballMachineAllCoins);
                    gumballMachineAllCoins.start();
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
