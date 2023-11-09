import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MediumEx
{
    //1.	Write a function that takes two arrays of integers and returns a new array that contains the elements that are common to both arrays.
    public static int[] commonElements(int[] firstArr, int[] secondArr)
    {
        List<Integer> listWithCommonElements = new ArrayList<>();
        //outer loop to iterate the first array
        for(int x: firstArr)
        {
            //inner loop to compare the elements of the first array to the second array
            for(int y: secondArr)
            {
                //condition to check if the value in the first array matches any value in the second array
                if(x == y)
                {
                    //add it to our list
                    listWithCommonElements.add(x);
                }
            }
        }

        int[] arrWithCommonElements = new int[listWithCommonElements.size()];
        for(int i = 0; i < arrWithCommonElements.length; i++)
        {
            arrWithCommonElements[i] = listWithCommonElements.get(i);
        }

        return arrWithCommonElements;
    }

    public static void printCommonArrElements()
    {
        int[] first = {1, 2, 3, 4, 5};
        int[] second ={6, 9, 2, 1, 4};
        int[] a = commonElements(first, second);
        for(int x: a)
        {
            System.out.print(x + " ");
        }
    }

//    2.	Write a function that takes an array of strings and returns the average length of the strings in the array.

    public static double averageLength(String[] arrOfStrings)
    {
        int total = 0;
        for (String arrOfString : arrOfStrings) {
            total += arrOfString.length();
        }
        return (double) total /arrOfStrings.length;
    }

    public static void printAverageLength()
    {
        String[] names = {"Tshepo", "Thabang", "Xoli", "Alfred", "Teboho"};
        double length = averageLength(names);
        System.out.println("The average length of the Strings: " + length);
    }
//    3.	Write a function that takes a string as input and returns the number of words in the string
    public static int numOfWordsInString(String myWord)
    {
        System.out.print("The number of words in " + myWord + " is: ");
        return myWord.length();
    }

//    4.	Write a function that takes an array of integers and returns the index of the first occurrence of the largest integer in the array.
    public static int indexOfLargestInt(int[] arr)
    {
        int max = arr[0];
        int indexOfLargeInt = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
                indexOfLargeInt = i;
            }
        }
        System.out.print("The index of the first occurrence of the largest int is: ");
        return indexOfLargeInt;
    }

//    5.	Write a function that takes an array of strings and returns a new array that contains only the strings that start with a vowel.
    public static String[] myString(String[] stringsThatStartWithVowel)
    {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        List<String> listToStoreStringsThatStartWithVowel = new ArrayList<>();

        for(String s: stringsThatStartWithVowel)
        {
            for(int i = 0; i < vowels.length; i++)
            {
                if(s.toLowerCase().charAt(0) == vowels[i])
                {
                    listToStoreStringsThatStartWithVowel.add(s);
                }
            }
        }

        String[] stringsWithVowel = new String[listToStoreStringsThatStartWithVowel.size()];
        for(int i = 0; i < stringsWithVowel.length; i++)
        {
            stringsWithVowel[i] = listToStoreStringsThatStartWithVowel.get(i);
        }

        return stringsWithVowel;
    }

    public static void printArrayWithVowels()
    {
        String[] words = {"Alfred", "Tshepo", "Anna", "Eat", "Out", "In"};
        System.out.print("Array that contains strings that start with a vowel: ");
        for(String s: myString(words))
        {
            System.out.print(s + " ");
        }
    }

//    6.	Write a function that takes an array of integers and returns a new array that contains the integers in sorted order.
    public static int[] sortingArray(int[] arr)
    {

        Arrays.sort(arr);
        return arr;
    }

    public static void printSortedArr()
    {
        int[] numArr = {2, 54, 7, 45, 86, 3};

        System.out.print("Sorted Array: ");
        for(int i: sortingArray(numArr))
        {
            System.out.print(i + " ");
        }
    }

//    7.	Write a function that takes a string as input and returns the number of vowels in the string.
    public static int numberOfVowels(String myWord)
    {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int numberOfVowelsCounter = 0;
        for(int i = 0; i < myWord.length(); i++)
        {
            for(int j = 0; j < vowels.length; j++)
            {
                if(myWord.toLowerCase().charAt(i) == vowels[j])
                {
                    numberOfVowelsCounter++;
                }
            }
        }
        System.out.print("The number of vowels in " + myWord + " is: ");
        return numberOfVowelsCounter;
    }

//    8.	Write a function that takes an array of integers and returns the median of the integers in the array.
    public static double iReturnMedianOfGivenArr(int[] myArr)
    {
        Arrays.sort(myArr);
        double median = 0;
        if(myArr.length % 2 != 0)
        {
            median = myArr[myArr.length / 2];
        }
        else
        {
            median = (double) (myArr[myArr.length / 2] + myArr[(myArr.length / 2) - 1]) / 2;
        }
        return median;
    }

//    9.	Write a function that takes an array of strings and returns a new array that contains the strings in reverse order.
    public static String[] iReverseAnArray(String[] originalString)
    {
        List<String> listArray = new ArrayList<>();
        for(int i = originalString.length-1; i >= 0; i--)
        {
            listArray.add(originalString[i]);
        }

        String[] reversedArr = new String[listArray.size()];
        for(int i = 0; i < reversedArr.length; i++)
        {
            reversedArr[i] = listArray.get(i);
        }
        return reversedArr;
    }
    public static void iPrintReversedArray()
    {
        String[] a = {"T", "U", "B", "A", "T", "S", "I"};
        for(String s: iReverseAnArray(a))
            System.out.print(s + " ");
    }

//    10.	Write a function that takes an array of integers and returns the product of all the integers in the array.
    public static int iReturnAProductOfAnIntArr(int[] arrayOfNum)
    {
        int product = 1;
        for(int i: arrayOfNum)
        {
            product *= i;
        }
        return product;
    }

    public static void iPrintTheProduct()
    {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println("The product is: " + iReturnAProductOfAnIntArr(numbers));

    }
}

public class Main
{
    public static void main(String[] args)
    {
        MediumEx.iPrintTheProduct();
    }
}