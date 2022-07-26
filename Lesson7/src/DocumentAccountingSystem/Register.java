package DocumentAccountingSystem;

import DocumentAccountingSystem.Documents.Documents;

public class Register
{
    Documents[] documents = new Documents[10];
    int lastAddedDocumentPosition = 0;

    public void saveDocumentInTheRegister(Documents document)
    {
        if(lastAddedDocumentPosition >= 10)
        {
            lastAddedDocumentPosition = 0;
        }
        documents[lastAddedDocumentPosition] = document;
        lastAddedDocumentPosition++;
    }

    public void getInformationAboutDocument(Documents document)
    {
        document.outputInformation();
    }
}
