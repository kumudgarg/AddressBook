package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface AddressBook {
    public boolean createFile(String fileName);
    public ArrayList<PersonDetails> addPersonDetails(PersonDetails personDetails);
    public boolean save(String fileName,List<PersonDetails> personDetails) throws IOException;
    public List<PersonDetails> readPersonInfo(String fileName) throws FileNotFoundException;
    public boolean editPersonDetails(String phoneNumber,String fieldName,PersonDetails personDetails) throws IOException;
    public boolean deletePersonDetails(String fileName,String phoneNumber);
}
