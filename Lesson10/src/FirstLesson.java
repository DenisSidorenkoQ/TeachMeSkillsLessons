import java.util.Locale;

public class FirstLesson
{
    public static String getTwoBlocksOfFourDigits(final String str)
    {
        if (str.isEmpty())
        {
            return "";
        }
        return str.substring(0, 4) + str.substring(9, 13);
    }

    public static String getStringWithoutBlocksWithLetters(final String str)
    {
        if (str.isEmpty())
        {
            return "";
        }
        return str.substring(0, 5) + "***" + str.substring(8, 14) + "***" + str.substring(17, 22) ;
    }

    public static String getStringOnlyWithLetters(final String str)
    {
        if (str.isEmpty())
        {
            return "";
        }
        return "Letters:" + (str.substring(5, 8) + "/" + str.substring(14, 17) + "/" +
                str.charAt(19) + "/" + str.charAt(21)).toLowerCase(Locale.ROOT);
    }

    public static String getStringOnlyWithLettersStringBuilder(final String str)
    {
        if (str.isEmpty())
        {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        return "Letters:" + (stringBuilder.substring(5, 8) + "/" + stringBuilder.substring(14, 17) + "/" +
                stringBuilder.charAt(19) + "/" + stringBuilder.charAt(21)).toUpperCase(Locale.ROOT);
    }

    public static boolean checkABC(final String str)
    {
        return str.contains("abc") || str.contains("ABC");
    }

    public static boolean checkStartWith555(final String str)
    {
        return str.startsWith("555");
    }

    public static boolean checkEndWith1a2b(final String str)
    {
        return str.endsWith("1a2b");
    }
}
