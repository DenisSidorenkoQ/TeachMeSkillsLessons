package DocumentAccountingSystem.Documents;

import java.util.Date;

public class ContractWithEmployee extends Documents implements Informatinable
{
    Date contractEndDate;
    String employeeName;

    public ContractWithEmployee()
    {

    }

    public ContractWithEmployee(int documentNumber, Date documentDate, Date contractEndDate, String employeeName)
    {
        super(documentNumber, documentDate);
        this.contractEndDate = contractEndDate;
        this.employeeName = employeeName;
    }

    public Date getContractEndDate()
    {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate)
    {
        this.contractEndDate = contractEndDate;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    @Override
    public void outputInformation()
    {
        System.out.println("Номер документа: " + this.documentNumber + "\nДата документа: " + this.documentDate.toLocaleString()
                + "\nИмя сотрудника: " + this.employeeName + "\nДата окончания контракта: " + this.contractEndDate.toLocaleString());
    }
}
