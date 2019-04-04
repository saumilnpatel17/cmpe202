public abstract class CreditCardDecorator implements IDisplayComponent, IKeyEventHandler {

    public IDisplayComponent wrappedDisplayComponent;

    public CreditCardDecorator ()
    {
        this.wrappedDisplayComponent = null;
    }

    public abstract String display();

    public void addSubComponent (IDisplayComponent c)
    {
        return; // do nothing
    }

    public void wrapDecorator (IDisplayComponent c)
    {
        this.wrappedDisplayComponent = c;
    }

    public void setNext (IKeyEventHandler next)
    {
        //do nothing.
    }
}
