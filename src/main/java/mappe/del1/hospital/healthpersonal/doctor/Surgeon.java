package mappe.del1.hospital.healthpersonal.doctor;
import mappe.del1.hospital.Patient;

/**
 * A surgeon in the hospital.
 */
public class Surgeon extends Doctor {

    /**
     * Creates an object of the Doctor class.
     *
     * @param firstName            first name of the doctor.
     * @param lastName             last name of the doctor.
     * @param socialSecurityNumber the doctor's social security number.
     */
    public Surgeon(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }

    @Override
    public String toString() {
        return "Kirurg: " + super.getFullName() + ", personnummer: "+ super.getSocialSecurityNumber();
    }
    public String asString() {
        return "Kirurg: " + super.getFullName() + ", personnummer: "+ super.getSocialSecurityNumber();
    }
}
