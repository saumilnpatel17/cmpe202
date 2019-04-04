public class SpaceDecorator extends CreditCardDecorator {

    String value = "";

    public String display()
    {
        String returnValue = "";

        for (int i = 0; i < value.length(); i+=4)
        {
            if ((i%4==0) && i>0)
            {
                returnValue += " ";
            }

            if ( (i+4) <= value.length())
                returnValue += value.substring(i, i+4);
            else
                returnValue += value.substring(i);
        }
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
