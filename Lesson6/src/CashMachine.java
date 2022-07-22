
public class CashMachine
{
    int countBanknotesDenominationTwenty;
    int countBanknotesDenominationFifty;
    int countBanknotesDenominationHundred;

    CashMachine(int denominationTwenty, int denominationFifty, int denominationHundred)
    {
        countBanknotesDenominationTwenty = denominationTwenty;
        countBanknotesDenominationFifty = denominationFifty;
        countBanknotesDenominationHundred = denominationHundred;
    }

    public void addMoney(int money)
    {
        while (money != 0)
        {
            if(money >= 100)
            {
                money -= 100;
                countBanknotesDenominationHundred++;
                continue;
            }
            if (money >= 50 && money < 100)
            {
                money -= 50;
                countBanknotesDenominationFifty++;
                continue;
            }
            if (money >= 20 && money < 50)
            {
                money -= 20;
                countBanknotesDenominationTwenty++;
            }
        }
    }

    public boolean withdrawMoney(int money)
    {
        int denominationHundredBuffer = countBanknotesDenominationHundred;
        int denominationFiftyBuffer = countBanknotesDenominationFifty;
        int denominationTwentyBuffer = countBanknotesDenominationTwenty;

        while (money != 0)
        {
            if (money >= 100 && countBanknotesDenominationHundred != 0)
            {
                money -= 100;
                countBanknotesDenominationHundred--;
                continue;
            }
            if ((money >= 50) && countBanknotesDenominationFifty != 0)
            {
                money -= 50;
                countBanknotesDenominationFifty--;
                continue;
            }
            if ((money >= 20) && countBanknotesDenominationTwenty != 0)
            {
                money -= 20;
                countBanknotesDenominationTwenty--;
            }
            else
            {
                break;
            }
        }
        if (countBanknotesDenominationHundred > 0 && countBanknotesDenominationFifty > 0 &&
        countBanknotesDenominationTwenty > 0)
        {
            System.out.println("Купюр номиналом 100: " + (denominationHundredBuffer - countBanknotesDenominationHundred)
                    + "\nКупюр номиналом 50: " + (denominationFiftyBuffer - countBanknotesDenominationFifty)
                    + "\nКупюр номиналом 20: " + (denominationTwentyBuffer - countBanknotesDenominationTwenty));
            return true;
        }
        else
        {
            countBanknotesDenominationHundred = denominationHundredBuffer;
            countBanknotesDenominationFifty = denominationFiftyBuffer;
            countBanknotesDenominationTwenty = denominationTwentyBuffer;
            return false;
        }
    }
}
