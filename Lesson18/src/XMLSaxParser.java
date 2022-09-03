import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLSaxParser extends DefaultHandler {
    String thisElement = "";
    List<String> lastNameList = new ArrayList();
    List<String> firstNameList = new ArrayList();
    List<String> titleList = new ArrayList();
    String text = "";

    public XMLSaxParser() {
    }

    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = qName;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.thisElement.equals("lastName")) {
            this.lastNameList.add(new String(ch, start, length));
        }

        if (this.thisElement.equals("firstName")) {
            this.firstNameList.add(new String(ch, start, length));
        }

        if (this.thisElement.equals("title")) {
            this.titleList.add(new String(ch, start, length));
        }

        if (this.thisElement.equals("line")) {
            String var10001 = this.text;
            this.text = var10001 + new String(ch, start, length) + "\n";
        }

    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        this.thisElement = "";
    }

    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}