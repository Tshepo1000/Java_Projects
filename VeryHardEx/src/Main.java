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

        //2.
    }
}