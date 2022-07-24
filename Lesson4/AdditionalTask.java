import java.util.Scanner;
import java.lang.Math;

public class AdditionalTask
{
    public static void evenArray()
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int size = 0;
        while (n < 5 || n > 10)
        {
            System.out.println("Введенное число не подходит");
            n = scan.nextInt();
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = (int) (Math.random() * 10) + 1;
            System.out.print(arr[i] + " ");
            if (arr[i] % 2 == 0)
            {
                size++;
            }
        }
        if (size == 0)
        {
            System.out.println("нету четных элементов");
            return;
        }
        int[] newArr = new int[size];
        int j = 0;
        System.out.println("\nМассиы с четными: ");
        for (int i = 0; i < n; i++)
        {
            if (arr[i] % 2 == 0)
            {
                newArr[j] = arr[i];
                System.out.println(newArr[j] + " ");
                j++;
            }
        }
    }
 
    public static void changeNotEvenIndexOnNull()
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
            if (i % 2 != 0)
            {
                arr[i] = 0;
            }
        System.out.print(arr[i] + " ");
        }
    }
    
    public static void sortString()
    {
        String[] str = { "Денис", "Антон", "Настя", "Коля"};
        for (int i = 0; i < str.length; i++)
        {
            System.out.print(str[i] + " ");
        }
        System.out.println();
        for (int out = str.length - 1; out >= 1; out--)
        {
            for (int in = 0; in < out; in++)
            {
                if(str[in].charAt(0) > str[in + 1].charAt(0))
                {
                    String dummy = str[in];
                    str[in] = str[in + 1];
                    str[in + 1] = dummy;          
                }             
            }
        }
        for (int i = 0; i < str.length; i++)
        {
            System.out.print(str[i] + " ");
        }
    }
 
 
    public static void bubbleSort(int[] arr)
    {
        for (int out = arr.length - 1; out >= 1; out--)
        {
            for (int in = 0; in < out; in++)
            {
                if(arr[in] > arr[in + 1])
                {
                    int dummy = arr[in];
                    arr[in] = arr[in + 1];
                    arr[in + 1] = dummy;          
                }             
            }
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
