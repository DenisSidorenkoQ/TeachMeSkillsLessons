import java.util.Scanner;
import java.lang.Math;

public class MainTask 
{

 
    public static void checkNumb(int[] arr)
    {
        System.out.println("Введите число для проверки: ");
        Scanner scan = new Scanner(System.in);
        int numb = scan.nextInt();
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == numb)
            {
                System.out.println("есть");
                return;
            }
        }
        System.out.println("нету");
  
    }
 
    public static int[] delNumb(int[] arr)
    {
        System.out.println("Введите число для удаления: ");
        Scanner scan = new Scanner(System.in);
        int numb = scan.nextInt();
        int n = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != numb)
            {
                n++;
            }
        }
        if (n == 0) 
        {
            System.out.println("нету");
            return new int[0];
        }
        int[] newArr = new int[n++];
        int i = 0;
        for (int j = 0; j < n; j++)
        {
            if (arr[j] != numb)
            {
                newArr[i] = arr[j];
                i++;
            }
        }
        return newArr;
    }
 
    public static void minAvgMaxInArr()
    {
        float max = 0;
        float min = 0;
        float avg = 0;
 
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = (int) (Math.random() * 10) + 1;
            if (i == 0)
            {
                min = arr[i];
                max = arr[i];
            }
            if (arr[i] < min)
            {
                min = arr[i];
            }
            if (arr[i] > max)
            {
                max = arr[i];
            } 
            avg += arr[i];
            System.out.println(arr[i]);
        }
        avg = avg / size;
        System.out.println("Avg = " + avg + "\nMin = " + min + "\nMax = " + max);
    }
 
    public static void checkAvgInArrays()
    {
        int[] firstArr = { 1, 2, 3, 4, 5 };
        int[] secondArr = { 6, 7, 8, 9, 10 };
        float firstAvg = 0;
        float secondAvg = 0;
        for (int i = 0; i < 5; i++)
        {
            System.out.print(firstArr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 5; i++)
        {
            System.out.print(secondArr[i] + " ");
        }
        for (int i = 0; i < 5; i++)
        {
            firstAvg += firstArr[i];
            secondAvg += secondArr[i];
        }
        firstAvg = firstAvg / 5;
        secondAvg = secondAvg / 5;
        if (firstAvg < secondAvg)
        {
            System.out.println("\nСреднее арифмет первого < второго");
        }
        if (firstAvg > secondAvg)
        {
            System.out.println("\nСреднее арифмет первого > второго");
        }
        if (firstAvg == secondAvg)
        {
            System.out.println("\nСреднее арифмет первого == среднму врифмет второго");
        }
    }
}
