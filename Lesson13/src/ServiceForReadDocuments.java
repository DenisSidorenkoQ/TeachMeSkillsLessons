import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.ArrayList;

public class ServiceForReadDocuments
{
    private final Path PATH_TO_FILE_WITH_VALID_NUMBER = Paths.get("D:\\rep\\TeachMeSkillsLessons\\Lesson13\\ValidNumber");
    private final Path PATH_TO_FILE_WITH_NOT_VALID_NUMBER = Paths.get("D:\\rep\\TeachMeSkillsLessons\\Lesson13\\NotValidNumber");
    private final String[] REASONS_FOR_VALIDATION_FAILURE = {"Document number is not 15", "Document number does not start with \"docnum\" or \"contract\""};
    private final String VALID_DOCUMENT_COMMENT = "The document is valid";
    private final String[] START_WORDS_FOR_DOCUMENTS = { "docnum", "contract"};

    private ArrayList<Path> getPaths()
    {
        //D:\rep\TeachMeSkillsLessons\Lesson13\DocumentNumbers
        ArrayList<Path> arrayList = new ArrayList<>();

        String buffer;
        try (Scanner scanner = new Scanner(System.in))
        {
            while(scanner.hasNextLine())
            {
                buffer = scanner.nextLine();
                if (buffer.equals("0"))
                {
                    return arrayList;
                }
                else
                {
                    arrayList.add(Paths.get(buffer));
                }
            }
        }
        return null;
    }
    public Map<String, String> fileDecompositionOfValidAndNotValidDocuments()
    {
        try
        {
            int countForValidDocument = 0;
            int countForNotValidDocument = 0;
            ArrayList<Path> arrayList = getPaths();
            Set<String> stringSet = new HashSet<>();

            String[] stringArray = null;

            for(int i = 0; i < arrayList.size(); i++)
            {
                stringSet.addAll(Arrays.asList(Files.readAllLines(arrayList.get(i)).toArray(new String[0])));
            }
            Map<String, String> documentMap = new HashMap<>();

            for (String str : stringSet)
            {
                if (str.length() == 15 && (str.startsWith(START_WORDS_FOR_DOCUMENTS[0]) ||
                        str.startsWith(START_WORDS_FOR_DOCUMENTS[1])))
                {
                    documentMap.put(str, VALID_DOCUMENT_COMMENT);
                    if(countForValidDocument == 0)
                    {
                        clearFile(PATH_TO_FILE_WITH_VALID_NUMBER);
                    }
                    outputValidNumberInFile(str);
                    countForValidDocument++;
                }
                else
                {
                    if(countForNotValidDocument == 0)
                    {
                        clearFile(PATH_TO_FILE_WITH_NOT_VALID_NUMBER);
                    }
                    if (str.length() != 15)
                    {
                        documentMap.put(str, REASONS_FOR_VALIDATION_FAILURE[0]);
                        outputNotValidNumberInFile(str, REASONS_FOR_VALIDATION_FAILURE[0]);
                    }
                    else
                    {
                        documentMap.put(str, REASONS_FOR_VALIDATION_FAILURE[1]);
                        outputNotValidNumberInFile(str, REASONS_FOR_VALIDATION_FAILURE[1]);
                    }
                    countForNotValidDocument++;
                }
            }
            return documentMap;
        }
        catch (IOException exception)
        {
            exception.getStackTrace();
        }
        return null;
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