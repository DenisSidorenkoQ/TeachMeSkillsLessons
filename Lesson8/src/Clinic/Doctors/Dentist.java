package Clinic.Doctors;

public class Dentist implements Healable
{
    @Override
    public void heal()
    {
        System.out.println("Лечит дантист");
    }
}
