public class functionalStyleStrategyPattern
{
    public static void runTest()
    {
        System.out.println("\u000C");
        DataSet dataset = new DataSet();
        System.out.println("\nBubble Sort Example");
        dataset.display();
        dataset.doSort();
        dataset.display();
        dataset.resetData();

        System.out.println("\nSelection Sort Example");
        dataset.display();
        dataset.changeStrategy(lambdaSortStrategies.SelectionSort);
        dataset.doSort();
        dataset.display();
    }
}
