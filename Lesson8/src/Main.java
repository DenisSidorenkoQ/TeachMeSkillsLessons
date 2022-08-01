import Clinic.ClinicalServices;
import Clinic.Patient;
import Clinic.TreatmentPlan;

public class Main
{
    public static void main(String[] args)
    {
        Phone firstPhone = new Phone(123241,"iPhone", 5);
        Phone secondPhone = new Phone(3523455,"Samsung", 5);
        Phone thirdPhone = new Phone(5437287,"Xiaomi", 5);
        System.out.println(firstPhone);
        System.out.println(secondPhone);
        System.out.println(thirdPhone);

        firstPhone.receiveCall("Герман", 213241);
        firstPhone.sendMessage(10, 20, 30, 40, 50, 60, 70, 80);

        System.out.println("\n\n\n");
        ClinicalServices clinicalServices = new ClinicalServices();
        Patient firstPatient = new Patient(new TreatmentPlan(1));
        clinicalServices.addATreatmentPlan(firstPatient);

        Patient secondPatient = new Patient(new TreatmentPlan(2));
        clinicalServices.addATreatmentPlan(secondPatient);

        Patient thirdPatient = new Patient(new TreatmentPlan(10));
        clinicalServices.addATreatmentPlan(thirdPatient);

    }
}
