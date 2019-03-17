import java.util.ArrayList;

public class Burger
{
    String burgerName;
    String burgerType;
    double burgerPrice;
    ArrayList<String> itemsOnTopBun;
    ArrayList<String> itemsOnBottomBun;
    ArrayList<String> itemsOnMeat;
    
    public Burger(String bName, String bType, double bPrice)
    {
        burgerName = bName;
        burgerType = bType;
        burgerPrice = bPrice;
        itemsOnTopBun = new ArrayList<String>();
        itemsOnMeat = new ArrayList<String>();
        itemsOnBottomBun = new ArrayList<String>();
    }
    
    public void addItemOnTopBun(String str)
    {
        itemsOnTopBun.add(str);
    }
    
    public void addItemOnMeat(String str)
    {
        itemsOnMeat.add(str);
    }
    
    public void addItemOnBottomBun(String str)
    {
        itemsOnBottomBun.add(str);
    }
}
