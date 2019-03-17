
public interface DisplayStrategy
{
    public String print(Order o);
    public String getTopSection();
    public String getBurgerDetailsSection();
    public String getSideItemSection();
    public String getBottomSection();
}
