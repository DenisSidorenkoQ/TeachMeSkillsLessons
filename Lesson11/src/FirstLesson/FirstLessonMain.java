package FirstLesson;

import FirstLesson.FirstLesson;

public class FirstLessonMain
{
    public static void main(String[] args)
    {
        try
        {
            FirstLesson.checkABC("1111-abf-2222-ggg-1f2g");
            System.out.println("Всё работает");
        }
        catch (CustomException exception)
        {
            System.out.println(exception);
        }

        try
        {
            FirstLesson.checkStartWith555("1111-abf-2222-ggg-1f2g");
            System.out.println("Всё работает");
        }
        catch (CustomException exception)
        {
            System.out.println(exception);
        }

        try
        {
            FirstLesson.checkEndWith1a2b("1111-abf-2222-ggg-1f2b");
            System.out.println("Всё работает");
        }
        catch (CustomException exception)
        {
            System.out.println(exception);
        }
    }
}
