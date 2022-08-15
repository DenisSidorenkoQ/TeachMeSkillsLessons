import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeviceForReadDocuments
{
    private final Path PATH_TO_FILE_WITH_VALID_NUMBER = Paths.get("D:\\rep\\TeachMeSkillsLessons\\Lesson12\\ValidNumber");
    private final Path PATH_TO_FILE_WITH_NOT_VALID_NUMBER = Paths.get("D:\\rep\\TeachMeSkillsLessons\\Lesson12\\NotValidNumber");
    private final String[] REASONS_FOR_VALIDATION_FAILURE = {"Document number is not 15", "Document number does not start with \"docnum\" or \"contract\""};
    private final String[] START_WORDS_FOR_DOCUMENTS = { "docnum", "contract"};


    public void fileDecompositionOfValidAndNotValidDocuments(Path filePath)
    {
        try
        {
            int countForValidDocument = 0;
            int countForNotValidDocument = 0;
            String[] stringArray = Files.readAllLines(filePath).toArray(new String[0]);

            for (int i = 0; i < stringArray.length; i++)
            {
                if (stringArray[i].length() == 15 && (stringArray[i].startsWith(START_WORDS_FOR_DOCUMENTS[0]) ||
                        stringArray[i].startsWith(START_WORDS_FOR_DOCUMENTS[1])))
                {
                    if(countForValidDocument == 0)
                    {
                        clearFile(PATH_TO_FILE_WITH_VALID_NUMBER);
                    }
                    outputValidNumberInFile(stringArray[i]);
                    countForValidDocument++;
                }
                else
                {
                    if(countForNotValidDocument == 0)
                    {
                        clearFile(PATH_TO_FILE_WITH_NOT_VALID_NUMBER);
                    }
                    if (stringArray[i].length() != 15)
                    {
                        outputNotValidNumberInFile(stringArray[i], REASONS_FOR_VALIDATION_FAILURE[0]);
                    }
                    else
                    {
                        outputNotValidNumberInFile(stringArray[i], REASONS_FOR_VALIDATION_FAILURE[1]);
                    }
                    countForNotValidDocument++;
                }
            }
        }
        catch (IOException exception)
        {
            exception.getStackTrace();
        }
    }

    public void clearFile(Path path) throws IOException
    {
        Files.writeString(path, "");
    }
    public void outputValidNumberInFile(String validNumber)
    {
        try
        {
            Files.writeString(PATH_TO_FILE_WITH_VALID_NUMBER, validNumber + "\n", StandardOpenOption.APPEND);
        }
        catch (IOException exception)
        {
            exception.getStackTrace();
        }
    }

    public void outputNotValidNumberInFile(String notValidNumber, String reason)
    {
        try
        {
            Files.writeString(PATH_TO_FILE_WITH_NOT_VALID_NUMBER, notValidNumber + " " +
                    reason + "\n", StandardOpenOption.APPEND);
        }
        catch (IOException exception)
        {
            exception.getStackTrace();
        }
    }
}
