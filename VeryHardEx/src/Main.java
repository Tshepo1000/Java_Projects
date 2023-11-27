class VeryHardEx
{
//    1.	Write a function that takes two arrays of integers and returns a new array that contains the elements that are not present in both arrays.
    public static int[] uniqueValues(int[] firstArr, int[] secondArr)
    {
        int count = 0;
        int[] tempArray = new int[firstArr.length + secondArr.length];

        for(int num: firstArr)
        {
            boolean isUnique = true;
            for(int num2: secondArr)
                if(num == num2)
                {
                    isUnique = false;
                    break;
                }

            if(isUnique)
            {
                tempArray[count] = num;
                count++;
            }

        }

        for(int num: secondArr)
        {
            boolean isUnique = true;
            for(int num1: firstArr)
            {
                if(num == num1)
                {
                    isUnique = false;
                    break;
                }
            }

            if(isUnique)
            {
                tempArray[count] = num;
                count++;
            }
        }

        int[] uniqueElements = new int[count];
        for(int i = 0; i < count; i++)
        {
            uniqueElements[i] = tempArray[i];
        }

        System.out.print("The unique elements are: ");
        return uniqueElements;
    }

//    2.	Write a function that takes an array of strings and returns a new array that contains the strings sorted by the number of vowels in each string.
    public static String[] sortByNumberOfVowels(String[] wordList)
    {
        int index = 0;
        int[] vowelsInWordlist = new int[wordList.length];

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for(String word: wordList)
        {
            int numberOfVowels = 0;

            for(int i = 0; i < word.length(); i++)
            {
                for (char vowel : vowels)
                    if (word.toLowerCase().charAt(i) == vowel)
                        numberOfVowels++;
            }

            vowelsInWordlist[index++] = numberOfVowels;
        }
//        {4, 1, 4, 1, 0, 2}
//        {"Virginia", "Ben", "olerato", "Chad", "Rhythm", "Tshepo"};
        String tempWord = "";
        int tempNum = 0;
        for(int i = 0; i < vowelsInWordlist.length-1; i++)
            for(int j = 0 + i; j < vowelsInWordlist.length; j++)
                if(vowelsInWordlist[i] >= vowelsInWordlist[j])
                {
                    tempWord = wordList[i];
                    tempNum = vowelsInWordlist[i];
                    wordList[i] = wordList[j];
                    vowelsInWordlist[i] = vowelsInWordlist[j];
                    wordList[j] = tempWord;
                    vowelsInWordlist[j] = tempNum;
                }

        String[] sortedByVowels = new String[vowelsInWordlist.length];
        for(int i = 0; i < sortedByVowels.length; i++)
            sortedByVowels[i] = wordList[i];

        System.out.print("Words sorted by number of vowels: ");
        return sortedByVowels;
    }

//    4.	Write a function that takes an array of integers and a target integer as input, and returns an array of pairs of integers in the array that add up to the target integer.
    public static int[][] keyPairs(int[] numbers, int targetNumber)
    {
        int count = 0;
        for(int number: numbers)
            for(int number1: numbers)
                    if(number + number1 == targetNumber)
                        count++;

        int[][] pairs = new int[count][];
        int index = 0;
        for(int number: numbers)
            for(int number1: numbers)
                    if(number + number1 == targetNumber)
                        pairs[index++] = new int[]{number, number1};

        System.out.print("Number that add up to " + targetNumber + ": ");
        return pairs;
    }

//    5.	Write a function that takes an array of strings and returns a new array that contains the strings sorted by the number of occurrences of a given character in each string.
    public static String[] sortByChar(String[] wordList, char letter)
    {
        int index = 0;
        int[] numberOfOccur = new int[wordList.length];

        for(String word: wordList)
        {
            int count = 0;
            for(int i = 0; i < word.length(); i++)
                if(word.charAt(i) == letter)
                    count++;

            numberOfOccur[index++] = count;
        }

        int count1 = 0;

        String[] tempArray = new String[wordList.length];
        for(String word: wordList)
        {
            for(int i = 0; i < word.length(); i++)
                if(word.charAt(i) == letter)
                {
                    tempArray[count1++] = word;
                    break;
                }
        }

        String[] arrayWithChar = new String[count1];
        for(int i = 0; i < count1; i++)
            arrayWithChar[i] = tempArray[i];

        String tempWord = "";
        int tempNum = 0;
        for(int i = 0; i < arrayWithChar.length; i++)
            for (int j = 0 + i; j < arrayWithChar.length; j++)
                if(numberOfOccur[i] >= numberOfOccur[j])
                {
                    tempWord = arrayWithChar[i];
                    tempNum = numberOfOccur[i];

                    arrayWithChar[i] = arrayWithChar[j];
                    numberOfOccur[i] = numberOfOccur[j];

                    arrayWithChar[j] = tempWord;
                    numberOfOccur[j] = tempNum;
                }

        String[] results = arrayWithChar;

        System.out.print("Words sorted by the character " + letter + ": ");
        return results;
    }

//    6.	Write a function that takes an array of integers and returns the second smallest integer in the array.
    public static int secondSmallestInt(int[] numbers)
    {
        //5, 3, 7, 9, 1, 4
        int min = numbers[0];

        for(int num: numbers)
            if(min >= num)
                min = num;

        int[] numbers2 = new int[numbers.length-1];
        int index = 0;

        for(int num: numbers)
            if(num > min)
                numbers2[index++] = num;

        int secondSmallest = numbers2[0];
        for(int num: numbers2)
            if(secondSmallest >= num)
                secondSmallest = num;

        System.out.print("The second smallest number is: ");
        return secondSmallest;
    }

//    8.	Write a function that takes an array of integers and a target integer as input, and returns an array of triplets of integers in the array that add up to the target integer.
    public static int[] addingNumbers(int[] numbers, int number)
    {
       int index = 0;
        int[] tempArray = new int[numbers.length];
        for(int num: numbers)
            for(int num1: numbers)
                for(int num2: numbers)
                    if(num + num1 + num2 == number)
                        tempArray = new int[]{num, num1, num2};

        System.out.print("Three numbers that add upto " + number + ": ");
        return tempArray;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        //1.
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 2, 1, 7, 8};

        for(int c: VeryHardEx.uniqueValues(a, b))
            System.out.print(c + " ");

        System.out.println();
        //2.
        String[] names = {"Virginia", "Ben", "olerato", "Chad", "Rhythm", "Tshepo"};
        for(String s: VeryHardEx.sortByNumberOfVowels(names))
            System.out.print(s + " ");

        System.out.println();

        //4.
        for(int[] x: VeryHardEx.keyPairs(a, 6))
            for(int y: x)
                System.out.print(y + " ");

        System.out.println();
        //5.
        String[] check = {"Tee", "Tshepo", "Dutchess", "Beenie", "Alfred", "Cici"};
        for(String s: VeryHardEx.sortByChar(check, 'e'))
            System.out.print(s + " ");

        System.out.println();

        //6.
        int[] n = {5, 3, 7, 2, 9, 1, 4};
        System.out.println(VeryHardEx.secondSmallestInt(n));

        //8.
        for(int nums: VeryHardEx.addingNumbers(a, 8))
            System.out.print(nums + " ");
    }
}