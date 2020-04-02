package io.ridsoftinformatiks.mahad.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "STUDENT_NUMBER")
    private String studentNumber;

    @Column(name = "FIRST_NAME")
    @NotBlank(message = "required")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotBlank(message = "required")
    private String lastName;

    @Column(name = "PLACE_OF_BIRTH")
    @NotBlank(message = "required")
    private String placeOfBirth;

    //@NotBlank(message = "required")
    @Column(name="DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    @NotBlank(message = "required")
    @Column(name = "TRIBE")
    private String tribe;

    @NotBlank(message = "required")
    @Column(name = "STATE_OF_ORIGIN")
    private String stateOfOrigin;

    @NotBlank(message = "required")
    @Column(name = "LOCAL_GOVERNMENT_OF_ORIGIN")
    private String localGovernmentOfOrigin;

    @NotBlank(message = "required")
    @Column(name = "NAME_OF_GUARDIAN")
    private String nameOfGuardian;

    @NotBlank(message = "required")
    @Column(name = "ADDRESS_OF_GUARDIAN")
    private String addressOfGuardian;

    @NotBlank(message = "required")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    //@NotBlank(message = "required")
    @Column(name="REGISTRATION_DATE")
    private LocalDate registrationDate;

    @Column(name = "STUDENT_HASH")
    private int studentHash;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentHash() {
        return studentHash;
    }

    public void setStudentHash(int studentHash) {
        this.studentHash = studentHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getLocalGovernmentOfOrigin() {
        return localGovernmentOfOrigin;
    }

    public void setLocalGovernmentOfOrigin(String localGovernmentOfOrigin) {
        this.localGovernmentOfOrigin = localGovernmentOfOrigin;
    }

    public String getNameOfGuardian() {
        return nameOfGuardian;
    }

    public void setNameOfGuardian(String nameOfGuardian) {
        this.nameOfGuardian = nameOfGuardian;
    }

    public String getAddressOfGuardian() {
        return addressOfGuardian;
    }

    public void setAddressOfGuardian(String addressOfGuardian) {
        this.addressOfGuardian = addressOfGuardian;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getStudentNumber(), student.getStudentNumber()) &&
                Objects.equals(getFirstName(), student.getFirstName()) &&
                Objects.equals(getLastName(), student.getLastName()) &&
                Objects.equals(getPlaceOfBirth(), student.getPlaceOfBirth()) &&
                Objects.equals(getDateOfBirth(), student.getDateOfBirth()) &&
                Objects.equals(getTribe(), student.getTribe()) &&
                Objects.equals(getStateOfOrigin(), student.getStateOfOrigin()) &&
                Objects.equals(getLocalGovernmentOfOrigin(), student.getLocalGovernmentOfOrigin()) &&
                Objects.equals(getNameOfGuardian(), student.getNameOfGuardian()) &&
                Objects.equals(getAddressOfGuardian(), student.getAddressOfGuardian()) &&
                Objects.equals(getPhoneNumber(), student.getPhoneNumber()) &&
                Objects.equals(getRegistrationDate(), student.getRegistrationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPlaceOfBirth(), getDateOfBirth(), getTribe(), getStateOfOrigin(), getLocalGovernmentOfOrigin(), getNameOfGuardian(), getAddressOfGuardian(), getPhoneNumber(), getRegistrationDate());
    }
}
