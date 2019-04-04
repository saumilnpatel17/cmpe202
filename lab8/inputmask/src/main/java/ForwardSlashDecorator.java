public class ForwardSlashDecorator extends CreditCardDecorator {

    String value = "";

    public String display()
    {
        String returnValue = "";

        if (value.length() > 2)
        {
            returnValue = value.substring(0,2) + "/" + value.substring((2));
        }
        else
            return value;

        return returnValue;
    }

    public void key(String ch, int cnt)
    {
        if( ch.equals("x"))
        {
            value = value.substring(0, value.length()-1);
        }
        else {
            value += ch;
        }
    }
}
