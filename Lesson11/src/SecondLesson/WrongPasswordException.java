package SecondLesson;

public class WrongPasswordException extends Exception
{
    WrongPasswordException()
    {
    }
    WrongPasswordException(String str)
    {
        super(str);
    }
}
