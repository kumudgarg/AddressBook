package com.bridgelab.addressbook.service;

import com.bridgelab.addressbook.model.PersonDetails;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AddressBookManager implements AddressBook {


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


}
