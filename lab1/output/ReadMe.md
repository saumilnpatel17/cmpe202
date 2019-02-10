Lab 1 Question 1:

In this program, I am creating gumball machine instance based on a user choice (1, 2 or 3).

I am passing two parameters to constructor when gumball machine object gets created.

1. size - how many gumballs this gumball machine has
2. amount - how much this gumball machine costs

Then I am calling "InsertCoin" method which accept one boolean parameter "onlyAcceptQuarters". If this is true then the selected gumball machine only accept quarters else it will accept any valid coin which are Nickels, Dimes and Quarters in this case.

In this program, the gumball machine will accept coins until user stops inserting coin. Once user choose to stop inserting coin, gumball machine machine will release the gumball and will keep the change if there is any.

******************************************************************

Lab 1 Question 2:

There are four existing states which were already given as the source. To complete my solution, I have added one more state "WaitingForCoinState". This state is to put Gumball Machine in waiting state. When user inserts coin but there are not sufficient coins to release a gumball, Gumball Machine will be put into "WaitingForCoin" State.