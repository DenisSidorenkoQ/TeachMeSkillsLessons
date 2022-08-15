package SecondLesson;

public class WrongLoginException extends Exception
{
    WrongLoginException()
    {
    }
    WrongLoginException(String str)
    {
        super(str);
    }
}
