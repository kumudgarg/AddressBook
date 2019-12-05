package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;

import java.util.ArrayList;

public interface AddressBook {
    public boolean createFile(String fileName);
    public PersonDetails addPersonDetails(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber);
}
