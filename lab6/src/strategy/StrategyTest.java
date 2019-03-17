 

public class StrategyTest
{
    public void runTest()
    {
        System.out.println("\u000C");
        Burger b1 = new Burger("LBB", "Bacon", 5.59);
        b1.addItemOnTopBun("LETTUCE");
        b1.addItemOnTopBun("TOMATO");
        b1.addItemOnMeat("G ONION");
        b1.addItemOnMeat("JALA Grilled");
        SideItem si1 = new SideItem("LTL CAJ", 2.79);
        Order o = new Order(20);
        o.addBurger(b1);
        o.addSideItem(si1);
        o.display();
        System.out.println("\n\n********************************\n\n");
        o.changeStrategy(new PackagingSlip());
        o.display();
        o.changeStrategy(new PaperReceipt());
        o.display();
    }
    
    public static void main( String [] args )
    {
        StrategyTest t = new StrategyTest();
        t.runTest();
    }
}