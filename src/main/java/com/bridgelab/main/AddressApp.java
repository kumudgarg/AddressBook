package com.bridgelab.main;

import com.bridgelab.addressbook.service.AddressBookManager;

public class AddressApp {

    public static void main(String[] args) {
        AddressBookManager addressBookManager = new AddressBookManager();
        if (addressBookManager.createFile("bridgelabAddress.json") == true) {
            System.out.println("file already exist");
        }
    }


}
