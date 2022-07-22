import Computer.Computer;
import Computer.HDD;
import Computer.RAM;

public class Main
{
    public static void main(String[] args)
    {
        creditCardLesson();
        System.out.println();
        computerLesson();
        System.out.println();
        cashMachineLesson();
    }

    public static void creditCardLesson()
    {
        CreditCard firstCreditCard = new CreditCard(123452542, 12f);
        CreditCard secondCreditCard = new CreditCard(54525245, 1000f);
        CreditCard thirdCreditCard = new CreditCard(22234252, 2000f);

        firstCreditCard.getInfo();
        secondCreditCard.getInfo();
        thirdCreditCard.getInfo();

        firstCreditCard.addMoneyOnAccountBalance(1000f);
        secondCreditCard.addMoneyOnAccountBalance(2000f);
        thirdCreditCard.withdrawMoneyFromAccountBalance(2000f);

        System.out.println();
        firstCreditCard.getInfo();
        secondCreditCard.getInfo();
        thirdCreditCard.getInfo();
    }

    public static void computerLesson()
    {
        Computer firstComputer = new Computer("AMD", 2000);
        firstComputer.getInfo();

        HDD hardDriveDisc = new HDD("Toshiba", 1000, "External");
        RAM randomAccessMemory = new RAM("Kingston ", 8000);
        Computer secondComputer = new Computer("AMD", 2000, hardDriveDisc, randomAccessMemory);
        System.out.println();
        secondComputer.getInfo();
    }

    public static void cashMachineLesson()
    {
        CashMachine cashMachine = new CashMachine(10, 10, 10);
        cashMachine.addMoney(370);
        cashMachine.withdrawMoney(370);
    }
}
