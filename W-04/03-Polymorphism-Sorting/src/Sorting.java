//********************************************************************
// Sorting.java
// Author: Lewis/Loftus
// Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************
import java.lang.Comparable;

public class Sorting
{
    //-----------------------------------------------------------------
    // Sorts the specified array of objects using the selection
    // sort algorithm.
    //-----------------------------------------------------------------
    public static <T extends Comparable<T>> void selectionSort (T[] list)
    {
        int min;
        T temp = null;

        for (int index = 0; index < list.length-1; index++)
        {
            min = index;
            for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[min]) < 0)
                min = scan;

            // Swap the values
            temp = list[min];
            list[min] = list[index];
            list[index] = temp;
        }
    }

    //-----------------------------------------------------------------
    // Sorts the specified array of objects using the insertion
    // sort algorithm.
    //-----------------------------------------------------------------
    public static <T extends Comparable<T>> void insertionSort(T[] list)
    {
        for (int i = 1; i < list.length; i++)
        {
            T nextItem = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(nextItem) < 0)
            {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = nextItem;
        }
    }
}