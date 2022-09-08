package Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDomParser {
    List<String> lastNameList = new ArrayList();
    List<String> firstNameList = new ArrayList();
    List<String> titleList = new ArrayList();
    String text = "";

    public XMLDomParser() {
    }

    public void parse(File FILE_FOR_READ) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(FILE_FOR_READ);
            doc.getDocumentElement().normalize();

            NodeList authorList = doc.getElementsByTagName("author");
            this.text = doc.getElementsByTagName("lines").item(0).getTextContent();

            for(int i = 0; i < authorList.getLength(); ++i) {
                Node authorNode = authorList.item(i);
                if (authorNode.getNodeType() == 1) {
                    Element element = (Element)authorNode;
                    this.firstNameList.add(element.getElementsByTagName("firstName").item(i).getTextContent());
                    this.lastNameList.add(element.getElementsByTagName("lastName").item(i).getTextContent());
                    this.titleList.add(doc.getElementsByTagName("title").item(i).getTextContent());
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException exception) {
            exception.getStackTrace();
        }

    }
}