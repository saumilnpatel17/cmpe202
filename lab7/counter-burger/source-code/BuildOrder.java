public class BuildOrder {

    public static Component getOrder()
    {
        Composite order = new Composite( "Order" ) ;
        //order.addChild(new Leaf("Crispy Onion Strings", 5.50 ));
        //order.addChild(new Leaf("The Purist", 8.00 ));

        /*CustomBurger customBurger = new CustomBurger( "Build Your Own Burger" ) ;
        // base price for 1/3 lb
        Burger b = new Burger( "Burger Options" ) ;
        String[] bo = { "Beef", "1/3lb.", "On A Bun" } ;
        b.setOptions( bo ) ;
        // 1 cheese free, extra cheese +1.00
        Cheese c = new Cheese( "Cheese Optios" ) ;
        String[] co = { "Danish Blue Cheese", "Horseradish Cheddar" } ;
        c.setOptions( co ) ;
        c.wrapDecorator( b ) ;
        // 4 toppings free, extra +.75
        Toppings t = new Toppings( "Toppings Options" ) ;
        String[] to = { "Bermuda Red Onion", "Black Olives", "Carrot Strings", "Coleslaw" } ;
        t.setOptions( to ) ;
        t.wrapDecorator( c ) ;
        // premium topping +1.50
        PremiumToppings p = new PremiumToppings( "Premium Toppings Options" ) ;
        String[] po = { "Applewood Smoked Bacon" } ;
        p.setOptions( po ) ;
        p.wrapDecorator( t ) ;
        // 1 sauce free, extra +.75
        Sauce s = new Sauce( "Sauce Options" ) ;
        String[] so = { "Appricot Sauce" } ;
        s.setOptions( so ) ;
        s.wrapDecorator( p ) ;
        
        // Setup Custom Burger Ingredients
        customBurger.setDecorator( s ) ;
        customBurger.addChild( b ) ;
        customBurger.addChild( c ) ;
        customBurger.addChild( t ) ;
        customBurger.addChild( p ) ;
        customBurger.addChild( s ) ;
        
        // Add Custom Burger to the ORder
        order.addChild( customBurger );
        return order ;*/
        
        CustomBurger customBurger1 = new CustomBurger("Build Your Own Burger");
        //base price for Organic Bison* 1/2 lb on a bun
        Burger bgr1 = new Burger("Burger Options");
        String[] bgro1 = {"Organic Bison*", "1/2lb.", "On A Bun"};
        bgr1.setOptions(bgro1);
        // 1 cheese free, extra cheese +1.00
        Cheese c1 = new Cheese("Cheese Options");
        String[] co1 = {"Yellow American", "Spicy Jalapeno Jack"};
        c1.setOptions(co1);
        c1.wrapDecorator(bgr1);
        // 1 premium cheese +1.50, extra premium cheese +1.50
        PremiumCheese pc1 = new PremiumCheese("Premium Cheese Options");
        String[] pco1 = {"Danish Blue Chesse"};
        pc1.setOptions(pco1);
        pc1.wrapDecorator(c1);
        // 1 sauce free, extra +.50
        Sauce s1 = new Sauce( "Sauce Options" ) ;
        String[] so1 = { "Mayonnaise", "Thai Peanut Sauce" } ;
        s1.setOptions( so1 ) ;
        s1.wrapDecorator( pc1 ) ;
        // unlimited toppings free
        Toppings t1 = new Toppings( "Toppings Options" ) ;
        String[] to1 = { "Dill Pickle Chips","Black Olives","Spicy Pickles" } ;
        t1.setOptions( to1 ) ;
        t1.wrapDecorator( s1 ) ;
        // premium topping +1.00 - +3.00 per selection
        PremiumToppings pt1 = new PremiumToppings( "Premium Toppings Options" ) ;
        String[] pto1 = { "Marinated Tomatoes" } ;
        pt1.setOptions( pto1 ) ;
        pt1.wrapDecorator( t1 ) ;
        // Bun +0.00 - +1.00 per selection
        Bun b1 = new Bun( "Bun Options" ) ;
        String[] bo1 = { "Ciabatta (Vegan)" } ;
        b1.setOptions( bo1 ) ;
        b1.wrapDecorator( pt1 ) ;
        // Side +3.00 per selection
        Side sd1 = new Side( "Side Options" ) ;
        String[] sdo1 = { "Shoestring Fries" } ;
        sd1.setOptions( sdo1 ) ;
        sd1.wrapDecorator( b1 ) ;
        
        
        // Setup Custom Burger Ingredients
        customBurger1.setDecorator( sd1 ) ;
        customBurger1.addChild( bgr1 ) ;
        customBurger1.addChild( c1 ) ;
        customBurger1.addChild( pc1 ) ;
        customBurger1.addChild( s1 ) ;
        customBurger1.addChild( t1 ) ;
        customBurger1.addChild(pt1);
        customBurger1.addChild(b1);
        customBurger1.addChild(sd1);
        
        // Add Custom Burger1 to the ORder
        order.addChild( customBurger1 );
        
        CustomBurger customBurger2 = new CustomBurger("Build Your Own Burger");
        //base price for Hormone & Antibiotic Free Beef 1/3 lb on a bun
        Burger bgr2 = new Burger("Burger Options");
        String[] bgro2 = {"Hormone & Antibiotic Free Beef*", "1/3lb.", "On A Bun"};
        bgr2.setOptions(bgro2);
        // 1 cheese free, extra cheese +1.00
        Cheese c2 = new Cheese("Cheese Options");
        String[] co2 = {"Smoked Gouda", "Greek Feta"};
        c2.setOptions(co2);
        c2.wrapDecorator(bgr2);
        // 1 premium cheese +1.50, extra premium cheese +1.50
        PremiumCheese pc2 = new PremiumCheese("Premium Cheese Options");
        String[] pco2 = {"Fresh Mozzarella"};
        pc2.setOptions(pco2);
        pc2.wrapDecorator(c2);
        // 1 sauce free, extra +.50
        Sauce s2 = new Sauce( "Sauce Options" ) ;
        String[] so2 = { "Habanero Salsa" } ;
        s2.setOptions( so2 ) ;
        s2.wrapDecorator( pc2 ) ;
        // unlimited toppings free
        Toppings t2 = new Toppings( "Toppings Options" ) ;
        String[] to2 = { "Crushed Peanuts" } ;
        t2.setOptions( to2 ) ;
        t2.wrapDecorator( s2 ) ;
        // premium topping +1.00 - +3.00 per selection
        PremiumToppings pt2 = new PremiumToppings( "Premium Toppings Options" ) ;
        String[] pto2 = { "Sunny Side Up Egg*","Marinated Tomatoes" } ;
        pt2.setOptions( pto2 ) ;
        pt2.wrapDecorator( t2 ) ;
        // Bun +0.00 - +1.00 per selection
        Bun b2 = new Bun( "Bun Options" ) ;
        String[] bo2 = { "Gluten-Free Bun" } ;
        b2.setOptions( bo2 ) ;
        b2.wrapDecorator( pt2 ) ;
        // Side +3.00 per selection
        Side sd2 = new Side( "Side Options" ) ;
        String[] sdo2 = { "Shoestring Fries" } ;
        sd2.setOptions( sdo2 ) ;
        sd2.wrapDecorator( b2 ) ;
        
        
        // Setup Custom Burger Ingredients
        customBurger2.setDecorator( sd2 ) ;
        customBurger2.addChild( bgr2 ) ;
        customBurger2.addChild( c2 ) ;
        customBurger2.addChild( pc2 ) ;
        customBurger2.addChild( s2 ) ;
        customBurger2.addChild( t2 ) ;
        customBurger2.addChild(pt2);
        customBurger2.addChild(b2);
        customBurger2.addChild(sd2);
        
        // Add Custom Burger to the ORder
        order.addChild( customBurger2 );
        return order ;
    }

}


/*

Counter Burger Menu:
https://thecounterburger.emn8.com/?store=Times%20Square

*/