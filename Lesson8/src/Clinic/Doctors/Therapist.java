package Clinic.Doctors;

public class Therapist implements Healable
{
    @Override
    public void heal()
    {
        System.out.println("Лечит терапевт");
    }
}
