
public class Task1
{
    public static void outputMonthByNumber(int monthNumber) //Написать программу для вывода названия поры года по номеру месяца.
    {
        switch (monthNumber)
        {
            case 1 :
            {
                System.out.println("Январь");
            } break;
            case 2 :
            {
                System.out.println("Февраль");
            } break;
            case 3 :
            {
                System.out.println("Март");
            } break;
            case 4 :
            {
                System.out.println("Апрель");
            } break;
            case 5 :
            {
                System.out.println("Май");
            } break;
            case 6 :
            {
                System.out.println("Июнь");
            } break;
            case 7 :
            {
                System.out.println("Июль");
            } break;
            case 8 :
            {
                System.out.println("Август");
            } break;
            case 9 :
            {
                System.out.println("Сентябрь");
            } break;
            case 10 :
            {
                System.out.println("Октябрь");
            } break;
            case 11 :
            {
                System.out.println("Ноябрь");
            } break;
            case 12 :
            {
                System.out.println("Декабрь");
            } break;
            default :
            {
                System.out.printf("Вы ввели не номер месяца");
            } break;

        }

    }

    public static void outputNameOfTheSeasonByMonthNumber(int monthNumber)  //Написать программу для вывода названия поры года по номеру месяца.
    {
        if (monthNumber >= 1 && monthNumber <= 3) System.out.println("Зима");
        else if (monthNumber >= 4 && monthNumber <= 6) System.out.println("Весна");
        else if (monthNumber >= 7 && monthNumber <= 9) System.out.println("Лето");
        else if (monthNumber >= 10 && monthNumber <= 12) System.out.println("Осень");
    }

    public static void evenChecking (int number)  //Напишите программу, которая будет принимать на вход число и на выход будет выводить сообщение четное число или нет.
    {
        if (number % 2 == 0) System.out.println("Число четное");
        else System.out.println("Нечетное число");
    }

    //Для введенного числа t (температура на улице) вывести
    //Если t>–5, то вывести «Тепло».
    //Если –5>= t > –20, то вывести «Нормально».
    //Если –20>= t, то вывести «Холодно».
    public static void checkTemperature (int temperature)
    {
        if (temperature > -5) System.out.println("Тепло");
        else if (temperature > -20 && temperature <= -5 ) System.out.println("Нормально");
        else if (temperature <= -20) System.out.println("Холодно");
    }

    //По введенному номеру определить цвет радуги (1 – красный, 4 – зеленый и т. д.).
    public static void checkColor(int colorNumber)
    {
        switch (colorNumber)
        {
            case 1 :
            {
                System.out.println("Красный");
            } break;
            case 2 :
            {
                System.out.println("Оранжевый");
            } break;
            case 3 :
            {
                System.out.println("Желтый");
            } break;
            case 4 :
            {
                System.out.println("Зелёный");
            } break;
            case 5 :
            {
                System.out.println("Голубой");
            } break;
            case 6 :
            {
                System.out.println("Синий");
            } break;
            case 7 :
            {
                System.out.println("Фиолетовый");
            } break;
            default :
            {
                System.out.println("Нету цвета с таким номером");
            } break;
        }
    }
}
