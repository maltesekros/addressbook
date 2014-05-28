import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by cmicallef on 27/05/2014.
 */
public class AddressBookTest {

    AddressBook addressBook;

    @Before
    public void createAddressBook() {
        addressBook = new AddressBook();
        DateTime dateTime = new DateTime(1940, 10, 9, 0, 0, 0, 0);
        AddressBookRecord addressBookRecord1 = new AddressBookRecord("John Lennon", dateTime.toDate(), AddressBookRecordGender.M);
        DateTime dateTime1 = new DateTime(1946, 12, 30, 0, 0, 0, 0);
        AddressBookRecord addressBookRecord2 = new AddressBookRecord("Patti Smith", dateTime1.toDate(), AddressBookRecordGender.F);
        DateTime dateTime2 = new DateTime(1941, 05, 24, 0, 0, 0, 0);
        AddressBookRecord addressBookRecord3 = new AddressBookRecord("Bob Dylan", dateTime2.toDate(), AddressBookRecordGender.M);
        addressBook.addAddressBookRecord(addressBookRecord1);
        addressBook.addAddressBookRecord(addressBookRecord2);
        addressBook.addAddressBookRecord(addressBookRecord3);
    }

    @Test
    public void testGetNumberOfMalesInAddressBook() {
        Assert.assertEquals(2, addressBook.getNumberOfMalesInAddressBook());
    }

    @Test
    public void testGetNameOfOldestPerson() {
        Assert.assertEquals("John Lennon", addressBook.getNameOfOldestPerson().getName());
    }

    @Test
    public void testDaysDifference() {
        AddressBookRecord johnLennon = addressBook.getRecords().get(0);
        AddressBookRecord pattiSmith = addressBook.getRecords().get(1);
        Assert.assertEquals(2273, addressBook.daysDifference(johnLennon, pattiSmith));
        Assert.assertEquals(-2273, addressBook.daysDifference(pattiSmith, johnLennon));
    }

    @Test
    public void testFindByName() {
        AddressBookRecord johnLennon = addressBook.findByName("Bob Dylan");
        Assert.assertNotNull(johnLennon);
        AddressBookRecord mickJagger = addressBook.findByName("Mick Jagger");
        Assert.assertNull(mickJagger);
    }
}
