package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AddressBookManager implements AddressBook {

    public ArrayList<PersonDetails> personInfo = new ArrayList<PersonDetails>();

    public static final String path = "/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/bridgelabAddress.json";

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
    public ArrayList<PersonDetails> addPersonDetails(PersonDetails personDetails) {
        personInfo.add(personDetails);
        return personInfo;

    }

    @Override
    public boolean save(String fileName, List<PersonDetails> personDetails) throws IOException {
        File file = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
        if (file.exists()) {
            Gson gson = new Gson();
            readPersonInfo(fileName);
            //personInfo.add(personDetails);
            String json = gson.toJson(personDetails);
            FileWriter writer = new FileWriter("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
            writer.write(json);
            writer.close();
            return true;
        }
        return false;
    }

    @Override
    public List<PersonDetails> readPersonInfo(String fileName) throws FileNotFoundException {
        File file = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
        if (file.exists()) {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(file));
            PersonDetails[] personDetails = gson.fromJson(br, PersonDetails[].class);
            for (int i = 0; i < personDetails.length; i++) {
                personInfo.add(personDetails[i]);
            }
            return personInfo;
        }
        return null;
    }

    @Override
    public boolean editPersonDetails(String phoneNumber, String fileName, PersonDetails personDetails) throws IOException {
        List<PersonDetails> personList = readPersonInfo(fileName);
        File file = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
        for (PersonDetails person : personList) {

            if (person.getPhoneNumber().equals(phoneNumber)) {
                person.setFirstName(personDetails.getFirstName());
                person.setLastName(personDetails.getLastName());
                person.setAddress(personDetails.getAddress());
                person.setCity(personDetails.getCity());
                person.setState(personDetails.getState());
                person.setZip(personDetails.getZip());
                person.setPhoneNumber(personDetails.getPhoneNumber());
                Gson gson = new Gson();
                String json = gson.toJson(personList);
                FileWriter writer = new FileWriter(file);
                writer.write(json);
                writer.close();
                return true;
            }

        }
        return false;

    }

    @Override
    public boolean deletePersonDetails(String fileName, String phoneNumber) {
        try {
            File file = new File("/home/admin105/Desktop/addressBook/src/main/java/com/bridgelab/addressbook/json/" + fileName);
            List<PersonDetails> personDetailsList = readPersonInfo(fileName);
            for (PersonDetails personDetails1: personDetailsList) {
                if (personDetails1.getPhoneNumber().equals(phoneNumber)) {
                    personDetailsList.remove(personDetails1);
                    Gson gson = new Gson();
                    String json = gson.toJson(personDetailsList);
                    FileWriter writer = new FileWriter(file);
                    writer.write(json);
                    writer.close();
                    return true;
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}
