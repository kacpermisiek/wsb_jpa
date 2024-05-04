package com.capgemini.wsb.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientTO implements Serializable {
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String telephoneNumber;
    protected String email;
    protected String patientNumber;
    protected LocalDate dateOfBirth;
    protected boolean isAdult;
    protected AddressTO address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        this.isAdult = adult;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }
}
