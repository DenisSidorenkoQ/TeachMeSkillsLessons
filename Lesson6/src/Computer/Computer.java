package Computer;

public class Computer
{
    String model;
    long cost;
    HDD hardDriveDisc;
    RAM randomAccessMemory;

    public Computer(String model, long cost)
    {
        this.model = model;
        this.cost = cost;
        hardDriveDisc = new HDD();
        randomAccessMemory = new RAM();
    }

    public Computer(String model, long cost, HDD hardDriveDisc, RAM randomAccessMemory)
    {
        this.model = model;
        this.cost = cost;
        this.hardDriveDisc = hardDriveDisc;
        this.randomAccessMemory = randomAccessMemory;
    }

    public void getInfo()
    {
        System.out.println("Модель: " + model + "\nЦена: " + cost);
        randomAccessMemory.getInfo();
        hardDriveDisc.getInfo();
    }
}
