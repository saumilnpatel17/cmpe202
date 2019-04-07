public class SpaceDecorator extends CreditCardDecorator {

    String value = "";

    public void setNext (IKeyEventHandler next)
    {
        ((CreditCardNum)wrappedDisplayComponent).setNext(next);
    }

    public String display()
    {
        value = wrappedDisplayComponent.display();
        if ( value.equals("") )
            return "[4444 4444 4444 4444]" + "  " ;
        else {
            String returnValue = "";

            for (int i = 0; i < value.length(); i += 4) {
                if ((i % 4 == 0) && i > 0) {
                    returnValue += " ";
                }

                if ((i + 4) <= value.length())
                    returnValue += value.substring(i, i + 4);
                else
                    returnValue += value.substring(i);
            }
            return "[" + returnValue + "]  ";
        }
    }

    public void key(String ch, int cnt)
    {
        ((CreditCardNum)wrappedDisplayComponent).key(ch, cnt);
    }
}
