package com.capgemini.wsb.dto;

import java.io.Serializable;

public class DoctorTO implements Serializable{
    protected Long id;
    protected String firstName;
    protected String lastName;
    protected String telephoneNumber;
    protected String email;
    protected String doctorNumber;
    protected String specialization;

    protected AddressTO address;


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getSpecialization(){
        return specialization;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getDoctorNumber(){
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber){
        this.doctorNumber = doctorNumber;
    }

    public String getTelephoneNumber(){
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }

    public AddressTO getAddress(){
        return address;
    }

    public void setAddress(AddressTO address){
        this.address = address;
    }
}
