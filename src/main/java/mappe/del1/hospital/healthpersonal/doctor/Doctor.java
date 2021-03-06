package mappe.del1.hospital.healthpersonal.doctor;
import mappe.del1.hospital.Patient;
import mappe.del1.hospital.Employee;

/**
 * An abstraction of a doctor in the hospital.
 * All doctors have a more defined class,
 * but share the traits of this class.
 */
abstract class Doctor extends Employee {
    /**
     * Creates an object of the Doctor class.
     *
     * @param firstName            first name of the doctor.
     * @param lastName             last name of the doctor.
     * @param socialSecurityNumber the doctor's social security number.
     */
    protected Doctor(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Sets the diagnosis of the patient in the parameter.
     * @param patient {@code Patient} to receive the diagnosis.
     * @param diagnosis {@code String} diagnosis to be given.
     */
    abstract void setDiagnosis(Patient patient, String diagnosis);
}
