package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface AddressBook {
    public boolean createFile(String fileName);
    public PersonDetails addPersonDetails(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber);
    public boolean save(String fileName) throws IOException;
    public boolean readPersonInfo(String fileName) throws FileNotFoundException;
}
