import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DocumentService
{
    private final Pattern DOCUMENT_NUMBER_PATTERN = Pattern.compile("([\\d]{4}\\-[a-zA-Z\\u0400-\\u04FF]{3}\\-){2}([\\d][a-zA-Z\\u0400-\\u04FF]){2}");
    private final Pattern TELEPHONE_NUMBER_PATTERN = Pattern.compile("\\+\\([\\d]{2}\\)[\\d]{7}");

    private List<File> getFilesFromFolder(Path path) throws IOException
    {
        return Files.walk(path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }

    public Map<String, Document> validationDocument(String pathToFolderWithDocument) throws IOException
    {
        //D:\rep\TeachMeSkillsLessons\Lesson17\src\DocumentsFolder

        int count = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
            }
            else {
                throw new RuntimeException("Not int");
            }
        }

        List<File> list = getFilesFromFolder(Paths.get(pathToFolderWithDocument));

        if (list.size() == 0) {
            throw new IOException("Folder is empty");
        }

        int countNotValidFiles = list.size();
        list = list.stream().filter((File file) -> file.getName().endsWith(".txt")).collect(Collectors.toList());

        if (list.size() == 0) {
            throw new IOException("There are no .txt files in the folder");
        }

        if (count < list.size()) {
            while(list.size() != count) {
                list.remove(list.size() - 1);
            }
        }

        int countValidFiles = list.size();
        countNotValidFiles -= countValidFiles;

        Matcher[] matcher = new Matcher[1];
        Map<String, Document> map = new HashMap<>();
        String[] info = new String[1];
        Document[] document = new Document[1];
        list.stream().forEach(file -> {
            try {
                info[0] = String.valueOf(Files.readAllLines(file.toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            document[0] = new Document();

            matcher[0] = DOCUMENT_NUMBER_PATTERN.matcher(info[0]);
            while (matcher[0].find()) {
                document[0].addDocument(matcher[0].group());
            }

            matcher[0] = TELEPHONE_NUMBER_PATTERN.matcher(info[0]);
            while (matcher[0].find()) {
                document[0].addDocument(matcher[0].group());
            }

            map.put(file.getName(), document[0]);
        });

        System.out.println("Валидные файлы: " + countValidFiles + "\tНевалидныйе файлы: " + countNotValidFiles);
        return map;
    }
}
