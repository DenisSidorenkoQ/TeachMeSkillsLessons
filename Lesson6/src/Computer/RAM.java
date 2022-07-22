package Computer;

public class RAM
{
    String name;
    int volume;

    RAM()
    {
        name = "undefined";
        volume = 0;
    }

    public RAM(String name, int volumeMb)
    {
        this.name = name;
        this.volume = volumeMb;
    }

    public void getInfo()
    {
        System.out.println("Название RAM: " + name + "\nОбъем памяти: " + volume);
    }
}
