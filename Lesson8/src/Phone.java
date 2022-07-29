public class Phone
{
    private int number;
    private String model;
    private float weight;

    public Phone()
    {

    }

    public Phone(int number, String model)
    {
        this.number = number;
        this.model = model;
    }

    public Phone(int number, String model, float weight)
    {
        this(number, model);
        this.weight = weight;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return  "Номер: " + number +
                "\nМодель: " + model +
                "\nВес: " + weight;
    }

    public void receiveCall(String callerName)
    {
        System.out.println("Звонит {" + callerName + "}");
    }

    public void receiveCall(String callerName, int callerNumber)
    {
        System.out.println("Звонит {" + callerName + "}{" + callerNumber + "}");
    }

    public void sendMessage(int... arrayForNumbers)
    {
        for (int number : arrayForNumbers)
        {
            System.out.print(number + "\t");
        }
    }

}
