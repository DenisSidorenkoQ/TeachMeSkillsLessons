import java.lang.reflect.Array;
import java.util.Scanner;

public class SecondLesson
{

    public static String findTheShortestWord(String str)
    {
        if (str.isEmpty())
        {
            return "";
        }

        String[] strArray = str.split(" ");
        String shortestWord = strArray[0];

        for (String buffer : strArray)
        {
            if (shortestWord.length() >= buffer.length())
            {
                shortestWord = buffer;
            }
        }

        return shortestWord;
    }

    public static String findTheLongerWord(String str)
    {
        if (str.isEmpty())
        {
            return "";
        }

        String[] strArray = str.split(" ");
        String longerWord = strArray[0];

        for (String buffer : strArray)
        {
            if (longerWord.length() <= buffer.length())
            {
                longerWord = buffer;
            }
        }

        return longerWord;
    }

    public static String findWordWithMinimumDifferent(final String str)
    {
        if (str.isEmpty())
        {
            return "";
        }

        String[] strArray = str.split(" ");
        String wordWithMinimumDifferent = "";
        int countMinimumDifferent = 0;

        for (String buffer : strArray)
        {
            char[] charArray = buffer.toCharArray();
            for(int i = 0; i < buffer.length(); i++)
            {
                String[] splitArray = buffer.split((String.valueOf(charArray[i])));
                if (splitArray.length - 1 == -1)
                {
                    if (buffer.length() > countMinimumDifferent)
                    {
                        countMinimumDifferent = buffer.length();
                        wordWithMinimumDifferent = buffer;
                    }
                    continue;
                }
                if (splitArray.length - 1 > countMinimumDifferent)
                {
                    countMinimumDifferent = splitArray.length - 1;
                    wordWithMinimumDifferent = buffer;
                }
            }
        }
        return wordWithMinimumDifferent;
    }

    public static boolean checkingForAPalindrome(final String str, final int wordPosition)
    {
        String[] strArray = str.split(" ");
        if (wordPosition <= strArray.length && wordPosition >= 0) {
            return new StringBuilder(strArray[wordPosition]).reverse().toString().equals(strArray[wordPosition]);
        }
        return false;
    }

    public static String duplicationOfEachLetter(String str)
    {
        char[] charArray = str.toCharArray();
        String finalString = "";

        for (int i = 0; i < charArray.length; i++)
        {
            finalString += String.valueOf(charArray[i]) + String.valueOf(charArray[i]);
        }
        return finalString;
    }
}
