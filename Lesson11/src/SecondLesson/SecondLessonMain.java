package SecondLesson;

public class SecondLessonMain
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(SecondLesson.method("Denis", "13 fasdfa", "13 fasdfa"));
        }
        catch (WrongLoginException | WrongPasswordException exception)
        {
            System.out.println(exception);
        }
    }
}
