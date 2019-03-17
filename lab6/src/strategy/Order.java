import java.util.ArrayList;
import java.util.Random;

public class Order
{
    public int orderNumber;
    Random rand = new Random();
    public ArrayList<Burger> burgerList = new ArrayList<Burger>();
    public ArrayList<SideItem> sideItemList = new ArrayList<SideItem>();
    public double subTotalPrice = 0.00;
    public double tax = 0.00;
    public double totalPrice = 0.00;
    public double cash = 0.00;
    public int transactionNumber;
    private DisplayStrategy strategy;
    private String receipt = "";
    
    public Order(double c)
    {
        orderNumber = rand.nextInt(999);
        cash = c;
        transactionNumber = rand.nextInt(99999);
        strategy = new PaperReceipt();
    }
    
    public void addBurger(Burger b)
    {
        burgerList.add(b);
        subTotalPrice += b.burgerPrice;
        tax += b.burgerPrice * 0.09;
        totalPrice = subTotalPrice + tax;
    }
    
    public void addSideItem(SideItem si)
    {
        sideItemList.add(si);
        subTotalPrice += si.sideItemPrice;
        tax += si.sideItemPrice * 0.09;
        totalPrice = subTotalPrice + tax;
    }
    
    public void display()
    {
        receipt = strategy.print(this);
        System.out.println(receipt);
    }
    
    public void changeStrategy(DisplayStrategy s)
    {
        strategy = s;
    }
}
