public class MusicPlayer
{
    private String music_name = "";
    private String group = "";
    private String time = "";
    private int volume = 50;

    public void volume_down(int value)
    {
        if(this.volume - value < 0) this.volume = 0;
        this.volume -= value;
    }
    public void volume_up(int value)
    {
        if(this.volume + value > 100) this.volume = 100;
        this.volume += value;
    }
    public void change_music(String music_name, String group, String time)
    {
        if(this.music_name == music_name) return;
        this.music_name = music_name;
        this.group = group;
        this.time = time;
    }
    public void output()
    {
        System.out.println("Название песни: " + music_name + "\n" +
                "Название группы: " + group + "\n" +
                "Длина трека: " + time + "\n" +
                "Громкость трека: " + volume);
    }
}
