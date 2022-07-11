public class Execute
{
    public static void main(String[] args)
    {
        MusicPlayer mp = new MusicPlayer();
        mp.change_music("Name", "Name", "3:21");
        mp.change_music("Name", "Name", "3:21");
        mp.volume_down(30);
        mp.output();
    }
}
