/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

/**
 *  Main App Class for Displaying Screen.
 */
public class App {

    private Screen screen;
    private CreditCardNum num;
    private CreditCardExp exp;
    private CreditCardCVC cvc;
    private SpaceDecorator spaceDecorator;
    private ForwardSlashDecorator forwardSlashDecorator;
    private int count;

    public App() {

        screen = new Screen();
        num = new CreditCardNum();
        exp = new CreditCardExp();
        cvc = new CreditCardCVC();
        spaceDecorator = new SpaceDecorator();
        forwardSlashDecorator = new ForwardSlashDecorator();

        //Setup Decorator Pattern
        spaceDecorator.wrapDecorator(num);
        forwardSlashDecorator.wrapDecorator(exp);

        screen.addSubComponent(spaceDecorator);
        screen.addSubComponent(forwardSlashDecorator);
        screen.addSubComponent(cvc);

        count = 0;

    }

    public String display() {
        String output = "";
        output += "========================================\n";
        output += screen.name() + "\n";
        output += "========================================\n";
        output += "\n\n\n\n";
        output += screen.display() + "\n";
        output += "\n\n\n\n";
        output += "========================================\n";
        return output;
    }

    public void key(String ch) {

        if (ch.equalsIgnoreCase("x") || ch.equalsIgnoreCase("delete"))
        {
            if (count > 0) {
                screen.key("x", count);
                count--;
            }
        }
        else {
            try {
                if (count < 23) {
                    int input = Integer.parseInt(ch);

                    if (input >= 0 && input <= 9) {
                        count++;
                        screen.key(ch, count);
                    } else
                        System.out.println("Please enter one digit at a time.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
            }
        }
    }

}

