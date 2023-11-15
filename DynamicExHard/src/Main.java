import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class HardEx
{
//    1.	Write a function that takes two arrays of integers and returns a new array that contains the elements that are unique to both arrays.
    public static int[] uniqueElements(int[] firstArray, int[] secondArray)
    {
        //create hashsets
        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();

        //convert arrays to hashsets
        for(int i = 0; i < firstArray.length; i++)
        {
            //add values to our hashset
            firstSet.add(firstArray[i]);
        }

        for(int i = 0; i < secondArray.length; i++)
        {
            //add values to our hashset
            secondSet.add(secondArray[i]);
        }

        //create a list to store our values
        List<Integer> listToStoreValues = new ArrayList<>();

        //check if values in firstSet are present in secondSet
        for(int i: firstSet)
        {
            if(!secondSet.contains(i))
            {
                //add values to our list
                listToStoreValues.add(i);
            }
        }

        for(int j: secondArray)
        {
            if(!firstSet.contains(j))
            {
                listToStoreValues.add(j);
            }
        }

        int[] uniqueElementsInArray = new int[listToStoreValues.size()];
        for(int i = 0; i < uniqueElementsInArray.length; i++)
        {
            uniqueElementsInArray[i] = listToStoreValues.get(i);
        }
        return uniqueElementsInArray;
    }

    //    2.	Write a function that takes an array of strings and returns a new array that contains the strings in alphabetical order.
    public static String[] iSortStrings(String[] unsortedArray)
    {
        Arrays.sort(unsortedArray);
        String[] sortedArray = new String[unsortedArray.length];
        sortedArray = unsortedArray;


        return sortedArray;
    }

//    4.	Write a function that takes an array of integers and a target integer as input, and returns true if there are two integers in the array that add up to the target integer, and false otherwise.
    public static boolean addingNumbers(int[] numArray, int num)
    {
        boolean numInArray = false;
        for (int i: numArray)
        {
            for (int j : numArray)
                if (i + j == num)
                    numInArray = true;
        }

        System.out.print("Are there two integers that add up to " + num + ": ");
        return numInArray;
    }
}

public class Main
{
    public static void main(String[] args)
    {

    }
}