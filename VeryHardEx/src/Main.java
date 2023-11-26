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
    }
}