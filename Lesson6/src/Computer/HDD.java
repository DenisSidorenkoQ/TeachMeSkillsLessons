package Computer;

public class HDD
{
    String name;
    int volume;
    String Type;

    HDD()
    {
        name = "undefined";
        volume = 0;
        Type = "undefined";
    }

    public HDD(String name, int volume, String Type)
    {
        this.name = name;
        this.volume = volume;
        this.Type = Type;
    }

    public void getInfo()
    {
        System.out.println("Название HDD: " + name + "\nОбъем памяти: " + volume + "\nТип: " + Type);
    }
}
