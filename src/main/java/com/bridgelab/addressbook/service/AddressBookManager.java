package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    @Override
    public boolean save(String fileName) throws IOException {
        File file = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
        if (file.exists()) {
            Gson gson = new Gson();
            String json = gson.toJson(personInfo);
            FileWriter writer = new FileWriter("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
            writer.write(json);
            writer.close();
            return true;
        }
        return false;
    }

    @Override
    public boolean readPersonInfo(String fileName) throws FileNotFoundException {
        File file = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
        if (file.exists()) {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(file));
            PersonDetails[] personDetails = gson.fromJson(br,PersonDetails[].class);
            System.out.println(Arrays.toString(personDetails));
            return true;
        }
        return false;
    }


}
