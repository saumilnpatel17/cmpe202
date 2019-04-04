/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

public class CreditCardNum implements IDisplayComponent, IKeyEventHandler
{

	private SpaceDecorator decorator;
	private IKeyEventHandler nextHandler ;
	public String number = "" ;

    public void setNext( IKeyEventHandler next) {
    	this.nextHandler = next ;
    }	

	public String display() {
		if ( number.equals("") )
			return "[4444 4444 4444 4444]" + "  " ;
		else
			return "[" + this.decorator.display() + "]" ;
	}	

	public void key(String ch, int cnt) {
		if ( cnt <= 16 )
		{
			if( ch.equals("x"))
			{
				number = number.substring(0, number.length()-1);
			}
			else {
				number += ch;
			}
			this.decorator.key(ch, cnt);
		}
		else if ( nextHandler != null )
			nextHandler.key(ch, cnt) ;
	}	

	public void addSubComponent( IDisplayComponent c ) {
		return ; // do nothing
	}

	public void setDecorator (SpaceDecorator d)
	{
		this.decorator = d;
	}

}