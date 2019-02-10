
import java.util.Random;
public class HasCoinState implements State {
    GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertCoin() {
        System.out.println("You can't insert another Coin");
    }

    public void ejectCoin() {

        gumballMachine.totalCoinsInserted -= gumballMachine.coinsInserted.get(0);
        gumballMachine.coinsInserted.remove(0);
        System.out.println("Coin returned");

        if(gumballMachine.coinsInserted.size() == 0)
        {
            gumballMachine.setState(gumballMachine.getNoCoinState());
        }
        else
        {
            gumballMachine.setState(gumballMachine.getWaitingForCoinState());
        }
        //gumballMachine.setState(gumballMachine.getNoCoinState());
    }

    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.totalCoinsInserted = 0;
        gumballMachine.coinsInserted.clear();
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString() {
        return "waiting for turn of crank";
    }
}
