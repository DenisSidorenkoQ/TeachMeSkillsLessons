package SecondLesson;

public class SecondLesson
{
    static boolean authentication(final String login, final String password, final String confirmPassword)
            throws WrongLoginException, WrongPasswordException
    {
        if (login == null || password == null || confirmPassword == null)
        {
            return false;
        }

        if (login.length() > 20 && login.contains(" "))
        {
            throw new WrongLoginException("Неверный логин");
        }

        if (!password.equals(confirmPassword))
        {
            throw new WrongPasswordException("Пароль не верный");
        }

        if (password.length() > 20)
        {
            throw new WrongPasswordException("Длинна пароля должна быть меньше 20");
        }
        else
        {
            char[] charArray = password.toCharArray();
            int count = 0;
            for (int i = 0; i < charArray.length; i++)
            {
                if ((charArray[i] >= 48 && charArray[i] <= 57))
                {
                    count++;
                    break;
                }
            }
            if (count != 0 && !password.contains(" "))
            {
                return true;
            }
            else
            {
                throw new WrongPasswordException("В пароле должна быть хотя бы одна цифра и не должно быть пробелов");
            }
        }
    }
}
