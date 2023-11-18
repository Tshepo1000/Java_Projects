import java.util.*;

class HardEx
{
//    1.	Write a function that takes two arrays of integers and returns a new array that contains the elements that are unique to both arrays.
    public static int[] uniqueElements(int[] firstArray, int[] secondArray)
    {
        int[] results = new int[firstArray.length + secondArray.length];
        int count = 0;


        for(int num1: firstArray)
        {
            boolean isUnique = true;
            for(int num2: secondArray)
                if(num1 == num2)
                {
                    isUnique = false;
                    break;
                }

            if(isUnique)
                results[count++] = num1;
        }

        for(int num2: secondArray)
        {
            boolean isUnique = true;
            for(int num1: firstArray)
                if(num2 == num1)
                {
                    isUnique = false;
                    break;
                }

            if(isUnique)
                results[count++] = num2;
        }

        int[] uniqueResults = new int[count];
        for(int i = 0; i < count; i++)
            uniqueResults[i] = results[i];

        return uniqueResults;
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

//    5.	Write a function that takes an array of strings and a character as input, and returns a new array that contains only the strings that contain the character.
    public static String[] isCharInMyString(String[] wordList, char letter)
    {
        int count = 0;
       for(String word: wordList)
           for(int i = 0; i < word.length(); i++)
               if(word.toLowerCase().charAt(i) == letter || word.toUpperCase().charAt(i) == letter)
               {
                   count++;
                   break;
               }

       String[] wordsResults = new String[count];
       int index = 0;
       for(String word: wordList)
           for (int i = 0; i < word.length(); i++)
               if(word.toLowerCase().charAt(i) == letter || word.toUpperCase().charAt(i) == letter)
               {
                   wordsResults[index] = word;
                   index++;
                   break;
               }

       return wordsResults;
    }

//    6.	Write a function that takes an array of integers and returns the mode (most frequently occurring integer) of the integers in the array.
    public static int mostFrequentNum(int[] arrayOfInt)
    {
    return 0;
    }

//    9.	Write a function that takes an array of strings and returns a new array that contains the strings sorted by length (shortest to longest).
    public static String[] sortedByLength(String[] unsortedArr)
    {
        String wordStorage = "";
        for(int i = 0; i < unsortedArr.length - 1; i++)
            for(int j = 0 + i; j < unsortedArr.length; j++)
                if(unsortedArr[i].length() >= unsortedArr[j].length())
                {
                    wordStorage = unsortedArr[i];
                    unsortedArr[i] = unsortedArr[j];
                    unsortedArr[j] = wordStorage;
                }

        String[] sortedArray = new String[unsortedArr.length];
        for(int i = 0; i < unsortedArr.length; i++)
            sortedArray[i] = unsortedArr[i];

        return sortedArray;
    }

//    10.	Write a function that takes two arrays of integers and returns a new array that contains the elements that appear in both arrays in the order that they appear in the first array. If there are duplicates, they should only appear once in the output.
    public static int[] commonElements(int[] firstArr, int[] secondArr)
    {
        int[] results = new int[firstArr.length + secondArr.length];
        int count = 0;

        for(int num1: firstArr)
        {
            boolean isCommon = false;
            for(int num2: secondArr)
                if(num1 == num2)
                {
                    isCommon = true;
                    break;
                }
            if(isCommon)
                results[count++] = num1;
        }

        int[] commonValues = new int[count];
        for(int i = 0; i < count; i++)
            commonValues[i] = results[i];

        return commonValues;
    }

}

public class Main
{
    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5, 6, 10};
        int[] b = {19, 2, 3, 7, 5, 10};

        for(int n: HardEx.commonElements(a, b))
            System.out.print(n + " ");
    }
}