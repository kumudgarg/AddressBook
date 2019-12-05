import com.bridgelab.addressbook.model.PersonDetails;
import com.bridgelab.addressbook.service.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

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
}

