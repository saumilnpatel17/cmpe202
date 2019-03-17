Lab 6 Implementation:

I have created StrategyTest Class which contains the main method.

There is one class Order which holds the full order. There are 2 other classes for Burgers and SideItems (e.g. Fries, Milkshake). Burgers and SideItems are added in the Order.
The Order has a reference of DisplayStrategy.

There is an interface DisplayStrategy which declares methods to be implemented in Classes that implements DisplayStrategy interface.

The 2 classes which implement DisplayStrategy are PaperReceipt and Packaging Slip. Both of these classes print the order in different style.

The StrategyTest creates Order and adds Burger(s) and Sideitem(s) in the Order. Then, StrategyTest sets the strategy in the Order's DisplayStrategy reference. Based on what object DisplayStrategy's reference points to, the receipt will be printed.

The printed receipt can be PaperReceipt or PackagingSlip.

Following is an exaplme of output:

By default, the DisplayStrategy points to PaperReceipt.

*****************************PAPER RECEIPT*****************************

          FIVE GUYS          
      BURGERS AND FRIES      
       STORE # CA-1294       
    5353 ALMADEN EXPY N60    
      SAN JOSE, CA 95118     
       (P) 408-264-9300      

     2019/03/16 21:23:38

          FIVE GUYS          
Order Now: 71

1     LBB                           $5.59
       {{{{ Bacon }}}}
       LETTUCE
       TOMATO
       ->|G ONION
       ->|JALA Grilled

1     LTL CAJ                       $2.79

      Sub. Total:                   $8.38
      Tax:                          $0.75
      Total:                        $9.13

      Cash                          $20.00
      Change                        $10.87
Register:1           Tran Seq No:    64801
Cashier:Patel* S.
**************************************************************************
      Don't throw away your receipt!!!!


********************************

DisplayStrategy is changed and now it is pointing to PackagingSlip

*****************************Packaging Slip*****************************

Patties - 1

Order Number: 71
     2019/03/16 21:23:38

          FIVE GUYS          
Sandwich#  1
1     LBB
    LETTUCE
    TOMATO
    ->|G ONION
    ->|JALA Grilled
    {{{{ Bacon }}}}

1   LTL CAJ                       

Register:1           Tran Seq No:    64801
Cashier:Patel* S.
***********************************************************************

DisplayStrategy is changed again and now it is pointing PaperReceipt.

*****************************PAPER RECEIPT*****************************

          FIVE GUYS          
      BURGERS AND FRIES      
       STORE # CA-1294       
    5353 ALMADEN EXPY N60    
      SAN JOSE, CA 95118     
       (P) 408-264-9300      

     2019/03/16 21:23:38

          FIVE GUYS          
Order Now: 71

1     LBB                           $5.59
       {{{{ Bacon }}}}
       LETTUCE
       TOMATO
       ->|G ONION
       ->|JALA Grilled

1     LTL CAJ                       $2.79

      Sub. Total:                   $8.38
      Tax:                          $0.75
      Total:                        $9.13

      Cash                          $20.00
      Change                        $10.87
Register:1           Tran Seq No:    64801
Cashier:Patel* S.
**************************************************************************
      Don't throw away your receipt!!!!
