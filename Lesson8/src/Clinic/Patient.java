package Clinic;

import Clinic.Doctors.Healable;

public class Patient
{
    private TreatmentPlan treatmentPlan;
    private Healable doctor;

    public Patient(TreatmentPlan treatmentPlan)
    {
        this.treatmentPlan = treatmentPlan;
    }

    public TreatmentPlan getTreatmentPlan()
    {
        return treatmentPlan;
    }

    public void setTreatmentPlan(TreatmentPlan treatmentPlan)
    {
        this.treatmentPlan = treatmentPlan;
    }

    public void setDoctor(Healable doctor)
    {
        this.doctor = doctor;
    }

    public void getHeal()
    {
        doctor.heal();
    }
}
