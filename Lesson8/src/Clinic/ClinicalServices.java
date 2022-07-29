package Clinic;

import Clinic.Doctors.Dentist;
import Clinic.Doctors.Surgeon;
import Clinic.Doctors.Therapist;

public class ClinicalServices
{
    public void addATreatmentPlan(Patient patient)
    {
        if (patient.getTreatmentPlan().getTreatmentPlanNumber() == 1)
        {
            patient.setDoctor(new Surgeon());
            patient.getHeal();
            return;
        }
        else if (patient.getTreatmentPlan().getTreatmentPlanNumber() == 2)
        {
            patient.setDoctor(new Dentist());
            patient.getHeal();
            return;
        }
        else
        {
            patient.setDoctor(new Therapist());
            patient.getHeal();
            return;
        }
    }
}
