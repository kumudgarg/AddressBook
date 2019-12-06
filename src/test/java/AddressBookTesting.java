import com.bridgelab.addressbook.model.PersonDetails;
import com.bridgelab.addressbook.service.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookTesting {

    @Test
    public void WhenGivenFileName_IfNotExist_ShouldReturnFalse() {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(false, addressBookManager.createFile("David'sAddress.json"));
    }

    @Test
    public void WhenAddPersonDetails_ShouldReturnPersonDetails() {
        AddressBookManager addressBookManager = new AddressBookManager();
        PersonDetails personDetails = new PersonDetails("prince", "singh", "vashi", "mumbai", "Mahratra", "124536", "9468679750");
        Assert.assertEquals("9468679750", addressBookManager.addPersonDetails(personDetails).iterator().next().getPhoneNumber());
    }

    @Test
    public void WhenSavePersonDetails_ItShouldWriteIntoJson() {
        AddressBookManager addressBookManager = new AddressBookManager();
        PersonDetails personDetails = new PersonDetails("kumud", "singh", "vashi", "mumbai", "Mahratra", "124536", "9468679750");

        try {
            Assert.assertEquals(true, addressBookManager.save("bridgelabAddress.json", addressBookManager.addPersonDetails(personDetails)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void WhenReadPersonDetails_ItShouldReadPersonDetailsFromJson() {
        AddressBookManager addressBookManager = new AddressBookManager();
        try {
            List<PersonDetails> list = addressBookManager.readPersonInfo("bridgelabAddress.json");
            boolean flag = false;
            if (list.size() != 0) {
                flag = true;
            }
            Assert.assertEquals(true, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void WhenEditPersonDetails_ShouldReturnUpdatedDetails() throws IOException {
        AddressBookManager addressBookManager = new AddressBookManager();
        PersonDetails personDetails = new PersonDetails("rajat", "Garg", "jaipur", "jaipur", "Mahratra", "124536", "9468679750");
        Assert.assertEquals(true, addressBookManager.editPersonDetails("9468679750", "bridgelabAddress.json", personDetails));
    }

    @Test
    public void WhenDeletedPersonDetails_ShouldReturnTrue() {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(true,addressBookManager.deletePersonDetails("bridgelabAddress.json","9468679750"));
    }
}


