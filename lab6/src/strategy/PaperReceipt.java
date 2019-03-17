import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaperReceipt implements DisplayStrategy
{
    private Order order;
    private String receiptPrint = "";
    
    public String print(Order o)
    {
        this.order = o;
        receiptPrint = getTopSection();
        receiptPrint += getBurgerDetailsSection();
        receiptPrint += getSideItemSection();
        receiptPrint += getBottomSection();
        
        return receiptPrint;
    }
    
    public String getTopSection()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();

        StringBuffer buff = new StringBuffer();

        buff.append("*****************************PAPER RECEIPT*****************************\n\n");
        buff.append("          FIVE GUYS          \n");
        buff.append("      BURGERS AND FRIES      \n");
        buff.append("       STORE # CA-1294       \n");
        buff.append("    5353 ALMADEN EXPY N60    \n");
        buff.append("      SAN JOSE, CA 95118     \n");
        buff.append("       (P) 408-264-9300      \n\n");
        buff.append("     " + dtf.format(now) + "\n\n");
        buff.append("          FIVE GUYS          \n");
        buff.append("Order Now: " + order.orderNumber + "\n\n");

        return buff.toString();
    }

    public String getBurgerDetailsSection()
    {
        StringBuffer buff = new StringBuffer();
        
        for(int i=0; i < order.burgerList.size(); i++)
        {
            buff.append((i+1) + "     " + String.format("%-30s", order.burgerList.get(i).burgerName) + "$" + order.burgerList.get(i).burgerPrice + "\n");
            buff.append("       {{{{ " + order.burgerList.get(i).burgerType + " }}}}\n");
            
            for(int j=0; j < order.burgerList.get(i).itemsOnTopBun.size(); j++)
            {
                buff.append("       " + order.burgerList.get(i).itemsOnTopBun.get(j) + "\n");
            }
            
            for(int j=0; j < order.burgerList.get(i).itemsOnMeat.size(); j++)
            {
                buff.append("       ->|" + order.burgerList.get(i).itemsOnMeat.get(j) + "\n");
            }
            
            for(int j=0; j < order.burgerList.get(i).itemsOnBottomBun.size(); j++)
            {
                buff.append("       " + order.burgerList.get(i).itemsOnBottomBun.get(j) + "\n");
            }
        }
        
        return buff.toString();
    }
    
    public String getSideItemSection()
    {
        StringBuffer buff = new StringBuffer();
        
        for(int i=0; i < order.sideItemList.size(); i++)
        {
            buff.append("\n" + (i+1) + "     " + String.format("%-30s", order.sideItemList.get(i).sideItemName) + "$" + order.sideItemList.get(i).sideItemPrice + "\n");
        }
        
        return buff.toString();
    }
    
    public String getBottomSection()
    {
        StringBuffer buff = new StringBuffer();
        
        buff.append("\n      " + String.format("%-30s", "Sub. Total:") + "$" + String.format("%.2f", order.subTotalPrice));
        buff.append("\n      " + String.format("%-30s", "Tax:") + "$" + String.format("%.2f", order.tax));
        buff.append("\n      " + String.format("%-30s", "Total:") + "$" + String.format("%.2f", order.totalPrice));
        buff.append("\n\n      " + String.format("%-30s", "Cash") + "$" + String.format("%.2f", order.cash));
        buff.append("\n      " + String.format("%-30s", "Change") + "$" + String.format("%.2f",((order.cash-order.totalPrice))));
        buff.append("\nRegister:1           Tran Seq No:    " + order.transactionNumber);
        buff.append("\nCashier:Patel* S.");
        buff.append("\n**************************************************************************");
        buff.append("\n      Don't throw away your receipt!!!!");
        
        return buff.toString();
    }

}
