public class SelectionSort implements SortingStrategy
{
    public void sort(int a[]) throws Exception
    {
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
    }
}
