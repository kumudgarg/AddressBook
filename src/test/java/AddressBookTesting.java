import com.bridgelab.addressbook.service.AddressBookManager;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTesting {

    @Test
    public void WhenGivenFileName_IfNotExist_ShouldReturnFalse() {
        AddressBookManager addressBookManager = new AddressBookManager();
        Assert.assertEquals(false,addressBookManager.createFile("David'sAddress.json"));
    }
}
