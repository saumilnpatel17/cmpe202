Lab 9 : Java Lambda Design Pattern

I have included examples of Strategy pattern.

In the First program, I have done Strategy pattern example using traditional Strategy pattern from Gang of Four books.

In the second program, I have implemented Lamnbda functions for two different sorting strategies (Bubble Sort and Selection Sort).

In the Strategy pattern example, Sorting Strategy is the interface which is implemented by two classes: Bubble Sort and Selection Sort. In this example, when user creates DataSet object, default sorting strategy gets assigned as BubbleSort. Then, user can change that strategy by changing strategy instance variable in DataSet class by assigning instance of SelectionSort to strategy instance variable.

In lambda example, instead of having two different classes for Concrete sorting strategies (Bubble Sort and Selection Sort in this case), it will have two lambda fucntions in "lambdaSortStrategies.java" class. This class will have two lambda functions, one for BubbleSort and one for SelectionSort. When user creates instance of DataSet, it will assign SortingStrategy instance variable a value of one of these lambda functions. In this case, the default value upon instance creation is BubbleSort lambda function. Then user can change the sorting strategy by assigning SelectionSort lambda function.