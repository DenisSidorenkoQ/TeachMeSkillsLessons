package DocumentAccountingSystem.Documents;

import java.util.Date;

public abstract class Documents implements Informatinable
{
    protected int documentNumber;
    protected Date documentDate;

    public Documents()
    {

    }
    public Documents(int documentNumber, Date documentDate)
    {
        this.documentNumber = documentNumber;
        this.documentDate = documentDate;
    }

    public int getDocumentNumber()
    {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    public Date getDocumentDate()
    {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate)
    {
        this.documentDate = documentDate;
    }
}
