import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        firstLesson();
        System.out.println("\n\n\n");
        secondLesson();
    }

    public static void firstLesson() {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^((0|1\\d{0,2}|2([0-4]|5[0-5]))\\.){3}(0|1\\d{0,2}|2([0-4]|5[0-5]))$");
        Matcher matcher = null;
        if (scanner.hasNextLine()) {
            matcher = pattern.matcher(scanner.next());
            System.out.println(matcher.matches());
        }
    }

    public static void secondLesson() throws IOException {
        DocumentService documentService = new DocumentService();

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                System.out.println(documentService.validationDocument(scanner.next()));
            }
        }
    }
}
