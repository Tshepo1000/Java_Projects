import java.util.Arrays;
import java.util.Scanner;

//1.	Write a function that takes an array of integers and returns the sum of all the integers.
class SumOfArray
{
    int sumOfNum(int[] arr)
    {
        int sum = 0;
        for(int i: arr)
        {
            sum += i;
        }
        return sum;
    }

    void additionResults(){
        int[] numbers = {1, 2, 3, 4, 5};
        int sumOfNumbers = sumOfNum(numbers);
        System.out.println("Array sum: " + sumOfNumbers);
    }
}

//2.	Write a function that takes an array of strings and returns the length of the shortest string in the array.
class ShortString
{
    public int shortestString(String[] s)
    {
        int min = s[0].length();
        for(String word: s)
            if(word.length() < min)
                min = word.length();

        return min;
    }
    public void shortStringresults()
    {
        String[] names = {"Tshepo", "Tee", "Chris", "Thabang", "Ve"};
        System.out.println("Length of shortest string: " + shortestString(names));
    }
}

//3.	Write a function that takes a string as input and returns the string in reverse order.
class Reversed
{
    public String reverseFunc(String word)
    {
        char[] words = word.toCharArray();
        String reversedWord = "";
        for(int i = word.length() - 1; i >= 0; i--)
        {
            reversedWord += words[i];
        }
        return reversedWord;
    }

    public void reversedwordRes()
    {
        String reversed = reverseFunc("MIS");
        System.out.println(reversed);
    }
}

//    4.	Write a function that takes two arrays of integers and returns a new array that contains the elements of both arrays.
class CombinationOfArrays
{
    public int[] addArrays(int[] firstArr, int[] secondArr)
    {
        int[] thirdArr = new int[firstArr.length + secondArr.length];

        for (int i = 0; i < firstArr.length; i++)
        {
            thirdArr[i] = firstArr[i];
        }

        for(int j = 0; j < secondArr.length; j++)
        {
            thirdArr[j + firstArr.length] = secondArr[j];
        }

        return thirdArr;
    }

    public void combinedArray()
    {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};

        int[] resultsArr = addArrays(a, b);

        for(int x: resultsArr)
        {
            System.out.print(x + " ");
        }
    }
}

//5.	Write a function that takes an array of integers and returns the largest integer in the array.
class LargeInt
{
    public int largestint(int[] nums)
    {
        int largest_num = 0;
        for(int n: nums)
        {
            if(largest_num < n)
                largest_num = n;
        }
        return largest_num;
    }

    public void largestNumber()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Array Length: ");
        int array_length = sc.nextInt();

        int[] numbers = new int[array_length];

        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(i + 1 + ": ");
            numbers[i] = sc.nextInt();
        }

        int largestNum = largestint(numbers);
        System.out.println("Largest Number in the array: " + largestNum);
    }

}

//6.	Write a function that takes an array of strings and a string as input,
//      and returns true if the string is present in the array, and false otherwise.
class PresentString
{
    public boolean string_present_in_array(String[] names, String name)
    {
        boolean checks_name = false;

        for(String s: names)
        {
            if(s.toLowerCase().equals(name.toLowerCase()))
            {
                checks_name = true;
                break;
            }
            else
            {
                checks_name = false;
            }


        }
        return checks_name;
    }

    public void present_string_in_array()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Array Length: ");
        int array_length = sc.nextInt();

        String[] names_in_array = new String[array_length];

        for(int i = 0; i < names_in_array.length; i++)
        {
            System.out.print("Name :" + (i + 1) + ": ");
            names_in_array[i] = sc.next();
        }

        System.out.print("Enter a name: ");
        String name = sc.next();

        boolean ans = string_present_in_array(names_in_array, name);
        System.out.println("Is the name present in the array: " + ans);
    }
}

//7.	Write a function that takes a string as input and returns true if the string is a palindrome, and false otherwise.

class Palindrome
{
    public boolean isPalindrome(String word)
    {
        boolean ans = false;
        String word_to_check = "";
        char[] word_arr = word.toCharArray();

        for(int i = word_arr.length - 1; i >= 0; i--)
        {
            word_to_check += word_arr[i];
        }

        if(word.toLowerCase().equals(word_to_check.toLowerCase()))
            ans = true;
        else
            ans = false;

        return ans;
    }

    public void palindromeResults()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to check if it's a palindrome: ");
        String myWord = sc.next();
        boolean is_palindrome = isPalindrome(myWord);
        System.out.println("Is " + myWord + " a palindrome: " + is_palindrome);
    }
}

//8.	Write a function that takes an array of integers and returns the index of the first occurrence of the smallest integer in the array.
class IndexOfSmallInt
{
    public int smallestIntIndex(int[] numbers)
    {
        int index = 0;
        int min = numbers[0];

        for(int i = 0; i < numbers.length; i++)
        {
            if(min >= numbers[i])
            {
                min = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public void smallInt()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Array Length: ");
        int array_length = sc.nextInt();

        int[] numbers = new int[array_length];

        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(i + 1 + ": ");
            numbers[i] = sc.nextInt();
        }

        int smallInt = smallestIntIndex(numbers);
        System.out.println("Index of smallest number: " + smallInt);
    }
}

//9.	Write a function that takes an array of strings and returns the string with the most characters.
class MostCharacters
{
    public String wordWithMostCharacter(String[] words)
    {
        int word_to_compare = words[0].length();
        String word_with_most_characters = "";

        for(int i = 0; i < words.length; i++)
        {
            if(word_to_compare <= words[i].length())
            {
                word_to_compare = words[i].length();
                word_with_most_characters = words[i];
            }
        }
        return word_with_most_characters;
    }

    public void mostCharWord()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Array Length: ");
        int array_length = sc.nextInt();

        String[] words_in_array = new String[array_length];

        for(int i = 0; i < words_in_array.length; i++)
        {
            System.out.print("Word :" + (i + 1) + ": ");
            words_in_array[i] = sc.next();
        }

        String resultingWord = wordWithMostCharacter(words_in_array);
        System.out.println("The string with most characters: " + resultingWord);
    }
}

//10.	Write a function that takes an array of integers and returns a new array that contains only the even integers in the original array.

class Even
{
    public int[] numberFunction(int[] numbers)
    {
        int count = 0;
        for(int num: numbers)
            if(num % 2 == 0)
                count++;

        int[] evenNumbers = new int[count];
        int index = 0;
        for(int num: numbers)
            if(num % 2 == 0)
            {
                evenNumbers[index] = num;
                index++;
            }

        return evenNumbers;
    }

    public void evenNumbersFunc()
    {
        int[] a = {3, 5, 6, 3, 4, 8, 9, 12};
        int[] b = numberFunction(a);
        for(int n: b)
        {
            System.out.print(n + " ");
        }

    }
}
public class Main
{
    public static void main(String[] args)
    {
        new CombinationOfArrays().combinedArray();
    }
}