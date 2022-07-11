import java.util.Scanner;

public class Task3
{
    //Выведите на экран первые 11 членов последовательности Фибоначчи.
    public static void Fibonacci()
    {
        int firstNumb = 1;
        int secondNumb = 1;
        System.out.print(firstNumb + "\t" + secondNumb);
        int sum;
        for(int i = 3; i <= 11; i++)
        {
            sum = firstNumb + secondNumb;
            System.out.print("\t" + sum);
            firstNumb = secondNumb;
            secondNumb = sum;
        }
    }

    /*За каждый месяц банк начисляет к сумме вклада 7% от суммы.
    Напишите программу, в которую пользователь вводит суммуи вклада
    количество месяцев. А банк вычисляет конечную сумму вклада с учетом
    начисления процентов за каждый месяц.
    Для вычисления суммы с учетом процентов используйте цикл for. Пусть
    сумма вклада будет представлять тип float.*/

    public static void bankOperation()
    {
        System.out.print("Введите сумму вклада: ");
        Scanner inputAmount = new Scanner(System.in);
        float depositAmount = inputAmount.nextFloat();

        System.out.println("Введите кол-во месяцев: ");
        Scanner inputMonthCount = new Scanner(System.in);
        int monthCount = inputAmount.nextInt();

        float moneyPlus = (depositAmount / 100) * 7;
        float Sum = depositAmount;
        for(int i = 0; i < monthCount; i++)
        {
            Sum += moneyPlus;
        }
        System.out.println(Sum);
    }

    public static void multiplicationTable()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.print("Умножение на " + i + ": ");
            for(int j = 1; j <= 10; j++)
            {
                System.out.print("\t" + i * j);
            }
            System.out.print("\n");
        }
    }


}
