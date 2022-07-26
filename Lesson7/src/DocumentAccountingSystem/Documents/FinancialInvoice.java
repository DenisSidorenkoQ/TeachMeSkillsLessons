package DocumentAccountingSystem.Documents;

import java.util.Date;

public class FinancialInvoice extends Documents implements Informatinable
{
    float monthlyTotal;
    int departmentCode;

    public FinancialInvoice()
    {

    }

    public FinancialInvoice(int documentNumber, Date documentDate, float monthlyTotal, int departmentCode)
    {
        super(documentNumber, documentDate);
        this.monthlyTotal = monthlyTotal;
        this.departmentCode = departmentCode;
    }

    public float getMonthlyTotal()
    {
        return monthlyTotal;
    }

    public void setMonthlyTotal(float monthlyTotal)
    {
        this.monthlyTotal = monthlyTotal;
    }

    public int getDepartmentCode()
    {
        return departmentCode;
    }

    public void setDepartmentCode(int departmentCode)
    {
        this.departmentCode = departmentCode;
    }

    public void outputInformation()
    {
        System.out.println("Номер документа: " + this.documentNumber + "\nДата документа: " + this.documentDate.toLocaleString()
                + "\nКод департамента: " + this.departmentCode + "\nИтоговая сумма за месяц: " + this.monthlyTotal);
    }
}
