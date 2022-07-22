public class CreditCard
{
    final long accountNumber;
    float accountBalance;

    CreditCard(long accountNumber, float accountBalance)
    {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    void getInfo()
    {
        System.out.println("Номер карты: " + accountNumber + "\nБаланс на карте: " + accountBalance);
    }

    public void addMoneyOnAccountBalance(float Money)
    {
        accountBalance += Money;
    }

    public void withdrawMoneyFromAccountBalance(float Money)
    {
        accountBalance -= Money;
    }
}
