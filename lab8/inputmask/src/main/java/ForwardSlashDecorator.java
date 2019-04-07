public class ForwardSlashDecorator extends CreditCardDecorator {

    String value = "";

    public void setNext (IKeyEventHandler next)
    {
        ((CreditCardExp)wrappedDisplayComponent).setNext(next);
    }

    public String display()
    {
        value = wrappedDisplayComponent.display();

        if ( value.equals("") )
            return "[MM/YY]" + "  " ;
        else {
            if (value.length() > 2) {
                value = value.substring(0, 2) + "/" + value.substring((2));
            }

            return "[" + value + "]  ";
        }
    }

    public void key(String ch, int cnt)
    {
        ((CreditCardExp)wrappedDisplayComponent).key(ch, cnt);
    }
}
