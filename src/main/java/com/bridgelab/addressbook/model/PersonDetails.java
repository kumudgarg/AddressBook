package com.bridgelab.addressbook.model;

public class PersonDetails {

    private String FirstName;
    private String LastName;
    private String Address;
    private String City;
    private String State;
    private long Zip;
    private long PhoneNumber ;

    public PersonDetails() {

    }

    public PersonDetails(String firstName, String lastName, String address, String city, String state, long zip, long phoneNumber) {
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        City = city;
        State = state;
        Zip = zip;
        PhoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public long getZip() {
        return Zip;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setState(String state) {
        State = state;
    }

    public void setZip(long zip) {
        Zip = zip;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Zip=" + Zip +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
