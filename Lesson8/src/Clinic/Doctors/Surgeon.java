package Clinic.Doctors;

public class Surgeon implements Healable
{
    @Override
    public void heal()
    {
        System.out.println("Лечит хирург");
    }
}
