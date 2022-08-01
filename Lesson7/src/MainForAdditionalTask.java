import DocumentAccountingSystem.Documents.ContractForTheSupply;
import DocumentAccountingSystem.Documents.ContractWithEmployee;
import DocumentAccountingSystem.Documents.FinancialInvoice;
import DocumentAccountingSystem.Register;

import java.util.Date;

public class MainForAdditionalTask
{
    public static void main(String[] args)
    {
        Register register = new Register();
        ContractForTheSupply contractForTheSupply = new ContractForTheSupply(1, new Date(),
                "Pencil", 100);
        register.saveDocumentInTheRegister(contractForTheSupply);
        register.getInformationAboutDocument(contractForTheSupply);
        System.out.println();

        Date contractEndDate = new Date();
        contractEndDate.setDate(27);
        contractEndDate.setMonth(7);
        contractEndDate.setYear(103);
        ContractWithEmployee contractWithEmployee = new ContractWithEmployee(2, new Date(),
                contractEndDate,"Денис");
        register.saveDocumentInTheRegister(contractWithEmployee);
        register.getInformationAboutDocument(contractWithEmployee);
        System.out.println();

        FinancialInvoice financialInvoice = new FinancialInvoice(3, new Date(),
                27000, 111);
        register.saveDocumentInTheRegister(financialInvoice);
        register.getInformationAboutDocument(financialInvoice);
        System.out.println();
    }
}
