package FirstLesson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateService
{
    final private Map<String, Integer> DAYS_OF_WEEK = new HashMap<>();
    final private String DAY_OF_THE_WEEK_PATTERN = "EEEE";
    final private String DAY_MONTH_YEAR_PATTERN = "dd-MM-YY";
    final private String[] BY_LOCALE = {"ru", "BY"};

    public DateService()
    {
        DAYS_OF_WEEK.put("понедельник", 1);
        DAYS_OF_WEEK.put("вторник", 7);
        DAYS_OF_WEEK.put("среда", 6);
        DAYS_OF_WEEK.put("четверг", 5);
        DAYS_OF_WEEK.put("пятница", 4);
        DAYS_OF_WEEK.put("суббота", 3);
        DAYS_OF_WEEK.put("воскресенье", 2);
    }
    public void printDayOfTheWeekName()
    {
        SimpleDateFormat date = new SimpleDateFormat(DAY_OF_THE_WEEK_PATTERN, new Locale(BY_LOCALE[0], BY_LOCALE[1]));
        System.out.println(date.format(new Date()));
    }

    public void printDateNextTuesday() throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DAY_OF_THE_WEEK_PATTERN,
                new Locale(BY_LOCALE[0], BY_LOCALE[1]));
        Date date = new Date();
        dateFormat.format(date);
        date.setTime(date.getTime() + DAYS_OF_WEEK.get(dateFormat.format(new Date())) * 86400000);
        dateFormat.applyPattern(DAY_MONTH_YEAR_PATTERN);
        System.out.println(dateFormat.format(date));
    }
}
