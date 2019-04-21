import java.util.function.*;

public class lambdaSortStrategies
{
    public static SortingStrategy BubbleSort = (a) ->{
        for (int i=a.length; --i>=0; )
        {
            boolean flipped = false;
            for (int j=0; j<i; j++)
            {
                if(a[j]>a[j+1])
                {
                    int T = a[j];
                    a[j] = a[j+1];
                    a[j+1] = T;
                    flipped = true;
                }
            }
            if (!flipped)
                return;
        }
    };
    
    public static SortingStrategy SelectionSort = (a) ->{
        int i, j, min_idx; 

        // One by one move boundary of unsorted subarray 
        for (i = 0; i < a.length-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            min_idx = i; 
            for (j = i+1; j < a.length; j++) 
                if (a[j] < a[min_idx]) 
                    min_idx = j; 

            // Swap the found minimum element with the first element
            int T = a[i];
            a[i] = a[min_idx];
            a[min_idx] = T;
        }
    };
}
