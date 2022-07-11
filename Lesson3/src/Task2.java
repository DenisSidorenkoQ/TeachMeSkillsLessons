import java.util.Scanner;

public class Task2
{
    public static void outputOddNumbers() // При помощи цикла for вывести на экран нечетные числа от 1 до 99.
    {
        for (int i = 1; i < 100; i++)
        {
            if (i % 2 != 0) System.out.print(i + "\t");
        }
    }

    //Необходимо вывести на экран числа от 5 до 1. При решении используйте операцию декремента
    public static void outputNumbersFromFiveToOne()
    {
        for(int i = 5; i >= 1; i--) System.out.print(i + "\t");
    }

    //Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует все числа от 1 до
    //введенного пользователем числа.
    public static void sumNumber()
    {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int sum = 0;
        for(int i = 1; i <= number; i++) sum += i;
        System.out.println(sum);
    }

    //Необходимо, чтоб программа выводила на экран вот такую
    //последовательность: 7 14 21 28 35 42 49 56 63 70 77 84 91 98.
    public static void outputNumbers()
    {
        int i = 7;
        while(i <= 98)
        {
            System.out.print(i + "\t");
            i += 7;
        }
    }

    //Вывести 10 первых чисел последовательности 0, -5,-10,-15.
    public static void outputTenNumbers()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.print(-1 * i * 5 + "\t");
        }
    }

    //Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно
    public static void numberSquares()
    {
        for(int i = 10; i <= 20; i++) System.out.print(i * i + "\t");
    }
}
