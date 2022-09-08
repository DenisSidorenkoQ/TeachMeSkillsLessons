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

    public List<String> getDocuments()
    {
        return documents;
    }

    public void setDocuments(List<String> documents)
    {
        this.documents = documents;
    }

    @Override
    public String toString()
    {
        return "Document{" + "documents=" + documents + '}';
    }

    public void split(Document document)
    {
        this.documents.addAll(document.getDocuments());
    }
}
