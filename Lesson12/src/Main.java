import java.nio.file.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Введите путь к файлу: "); // D:\rep\TeachMeSkillsLessons\Lesson12\DocumentNumbers
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(scanner.nextLine());

        SeviceForReadDocuments readDocument = new SeviceForReadDocuments();
        readDocument.fileDecompositionOfValidAndNotValidDocuments(path);

    }
}
