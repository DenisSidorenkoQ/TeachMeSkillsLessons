import java.util.ArrayList;
import java.util.List;

public class Document
{
    private List<String> documents = new ArrayList<>();

    Document()
    {
    }
    public void addDocument(String str)
    {
        documents.add(str);
    }

    @Override
    public String toString()
    {
        return "Document{" + "documents=" + documents + '}';
    }
}
