package SecondLesson;

import java.nio.file.Paths;
import java.util.Scanner;

public class Service
{
    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        String buffer = "";
        while(scanner.hasNextLine())
        {
            buffer = scanner.nextLine();
            if (buffer.equals("1"))
            {
                Interface<String> stringInterface;
                stringInterface = (str) -> {return new StringBuilder(str).reverse().toString();};
                System.out.println(stringInterface.work("TestString"));
                return;
            }
            if (buffer.equals("2"))
            {
                Interface<Integer> integerInterface;
                integerInterface = (number) -> {
                    int sum = 1;
                    for(int i = 1; i <= number; i++)
                    {
                        sum *= i;
                    }
                    return sum;
                };
                System.out.println(integerInterface.work(10));
                return;
            }
            else
            {
                return;
            }
        }
    }
}
