import com.bridgelab.addressbook.model.PersonDetails;
import com.bridgelab.addressbook.service.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTesting {

    @Test
    public void WhenGivenFileName_IfNotExist_ShouldReturnFalse() {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(false,addressBookManager.createFile("David'sAddress.json"));
    }

    @Test
    public void WhenAddPersonDetails_ShouldReturnPersonDetails(){
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals("9468679750",addressBookManager.addPersonDetails("kumud","garg","vashi","mumbai","Mahratra","124536","9468679750").getPhoneNumber());
    }

    @Test
    public void WhenSavePersonDetails_ItShouldWriteIntoJson(){
        AddressBookManager addressBookManager = new AddressBookManager();
        addressBookManager.addPersonDetails("kumud","garg","vashi","mumbai","Mahratra","124536","9468679750");
        try {
            Assert.assertEquals(true,addressBookManager.save("bridgelabAddress.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void WhenReadPersonDetails_ItShouldReadPersonDetailsFromJson(){
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            Assert.assertEquals(true,addressBookManager.readPersonInfo("bridgelabAddress.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


