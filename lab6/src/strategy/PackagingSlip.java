import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class PackagingSlip implements DisplayStrategy
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
        StringBuffer buff = new StringBuffer();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        
        buff.append("*****************************Packaging Slip*****************************\n\n");
        buff.append("Patties - " + order.burgerList.size() + "\n\n");
        buff.append("Order Number: " + order.orderNumber + "\n");
        buff.append("     " + dtf.format(now) + "\n\n");
        buff.append("          FIVE GUYS          \n");
        
        return buff.toString();
    }
    
    public String getBurgerDetailsSection()
    {
        StringBuffer buff = new StringBuffer();
        
        for(int i=0; i < order.burgerList.size(); i++)
        {
            buff.append("Sandwich#  " + (i+1) + "\n");
            buff.append((i+1) + "     " + order.burgerList.get(i).burgerName + "\n");
            
            for(int j=0; j < order.burgerList.get(i).itemsOnTopBun.size(); j++)
            {
                buff.append("    " + order.burgerList.get(i).itemsOnTopBun.get(j) + "\n");
            }
            for(int j=0; j < order.burgerList.get(i).itemsOnMeat.size(); j++)
            {
                buff.append("    ->|" + order.burgerList.get(i).itemsOnMeat.get(j) + "\n");
            }
            
            for(int j=0; j < order.burgerList.get(i).itemsOnBottomBun.size(); j++)
            {
                buff.append("       " + order.burgerList.get(i).itemsOnBottomBun.get(j) + "\n");
            }
            buff.append("    {{{{ " + order.burgerList.get(i).burgerType + " }}}}\n");
        }
        
        return buff.toString();
    }
    
    public String getSideItemSection()
    {
        StringBuffer buff = new StringBuffer();
        
        for(int i=0; i < order.sideItemList.size(); i++)
        {
            buff.append("\n" + (i+1) + "   " + String.format("%-30s", order.sideItemList.get(i).sideItemName) + "\n");
        }
        
        return buff.toString();
    }
    
    public String getBottomSection()
    {
        StringBuffer buff = new StringBuffer();
        
        buff.append("\nRegister:1           Tran Seq No:    " + order.transactionNumber);
        buff.append("\nCashier:Patel* S.");
        buff.append("\n***********************************************************************\n\n");
        
        return buff.toString();
    }
}
