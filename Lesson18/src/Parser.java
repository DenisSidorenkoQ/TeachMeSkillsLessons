import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

    public class Parser {
        private final String EMPTY_FOLDER_MESSAGE = "Folder is empty";
        private final String INPUT_NUMBER_OF_FILE_MESSAGE = "Input number of file";

        public Parser() {
        }

        public void startParse(String pathToFolderWithDocument) throws IOException, ParserConfigurationException, SAXException {
            Util util = new Util();
            List<File> fileList = util.getFilesFromFolder(Paths.get(pathToFolderWithDocument));
            int numberOfFile = 0;
            if (fileList.size() == 0) {
                System.out.println("Folder is empty");
            }

            if (fileList.size() > 1) {
                System.out.println("Input number of file");
                try (Scanner scanner = new Scanner(System.in)){
                    numberOfFile = scanner.nextInt() - 1;
                }
            }

            File FILE_FOR_READ = fileList.get(numberOfFile);
            System.out.println("Choose a parsing method");

            try (Scanner scanner = new Scanner(System.in)){
                if (scanner.nextInt() == 0) {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();
                    XMLSaxParser saxp = new XMLSaxParser();
                    parser.parse(FILE_FOR_READ, saxp);

                    for(int i = 0; i < saxp.lastNameList.size(); ++i) {
                        util.inputInFile(saxp.firstNameList.get(i) + "_" + saxp.lastNameList.get(i) +
                                "_" + saxp.titleList.get(i), saxp.text);
                    }
                    return;
                }

                if (scanner.nextInt() == 1) {
                    XMLDomParser xmlDomParser = new XMLDomParser();
                    xmlDomParser.parse(FILE_FOR_READ);

                    for(int i = 0; i < xmlDomParser.lastNameList.size(); ++i) {
                        util.inputInFile(xmlDomParser.firstNameList.get(i) + "_" +
                                xmlDomParser.lastNameList.get(i) +
                                "_" + xmlDomParser.titleList.get(i), xmlDomParser.text);
                    }
                    return;
                }
            }
        }
    }
