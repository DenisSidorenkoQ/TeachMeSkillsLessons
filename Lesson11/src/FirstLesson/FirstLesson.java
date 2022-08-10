package FirstLesson;

import java.io.IOException;

public class FirstLesson
{
    public static boolean checkABC(final String str) throws CustomException
    {
        if (str.contains("abc") || str.contains("ABC"))
        {
            return str.contains("abc") || str.contains("ABC");
        }
        else
        {
            throw new CustomException("abc не найдено");
        }
    }

    public static boolean checkStartWith555(final String str) throws CustomException
    {
        if (str.startsWith("555"))
        {
            return true;
        }
        else
        {
            throw new CustomException("555 не найдено");
        }
    }

    public static boolean checkEndWith1a2b(final String str) throws CustomException
    {
        if (str.endsWith("1a2b"))
        {
            return true;
        }
        else
        {
            throw new CustomException("1a2b не найдено");
        }
    }
}
