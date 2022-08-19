import FirstLesson.DateService;
import SecondLesson.Service;

import java.text.ParseException;

public class Main
{
    public static void main(String[] args) throws ParseException
    {
        firstLesson();
        secondLesson();
        secondLesson();
    }

    public static void firstLesson() throws ParseException
    {
        DateService dateService = new DateService();
        dateService.printDayOfTheWeekName();
        dateService.printDateNextTuesday();
    }

    public static void secondLesson()
    {
        Service service = new Service();
        System.out.println();service.start();
    }
}
