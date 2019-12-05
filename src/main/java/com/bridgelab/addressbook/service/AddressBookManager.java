package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddressBookManager implements AddressBook {

    ArrayList<PersonDetails> personInfo = new ArrayList<PersonDetails>();


    @Override
    public boolean createFile(String fileName) {
        File files = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
        boolean isFileExist = files.exists();
        if (isFileExist) {
            return true;
        }
        try {
            files.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public PersonDetails addPersonDetails(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber) {
        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName(firstName);
        personDetails.setLastName(lastName);
        personDetails.setAddress(address);
        personDetails.setCity(city);
        personDetails.setState(state);
        personDetails.setZip(zip);
        personDetails.setPhoneNumber(phoneNumber);
        personInfo.add(personDetails);
        return personDetails;

    }
}
