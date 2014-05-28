import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmicallef on 27/05/2014.
 */
public class AddressBook {

    private List<AddressBookRecord> records;

    /**
     * Public Constructor.
     */
    public AddressBook() {
        records = new ArrayList<AddressBookRecord>();
    }

    public void addAddressBookRecord(AddressBookRecord addressBookRecord) {
        records.add(addressBookRecord);
    }

    public List<AddressBookRecord> getRecords() {
        return records;
    }

    // ---- Utility Methods ----

    /**
     * Return number of Males in Address Book.
     * @return Number of Males. 0 if none are found.
     */
    public int getNumberOfMalesInAddressBook() {
        AddressBookRecordGender gender = AddressBookRecordGender.M;
        int noOfMales = getCountByGender(gender);
        return noOfMales;
    }

    private int getCountByGender(AddressBookRecordGender gender) {
        int count = 0;
        for (AddressBookRecord addressBookRecord : records) {
            if (addressBookRecord.getGender() == gender) {
                count++;
            }
        }
        return count;
    }

    /**
     * Get the oldest person in the Address Book. Return null if the address book is empty.
     * @return {@link AddressBookRecord} returned.
     */
    public AddressBookRecord getNameOfOldestPerson() {
        AddressBookRecord oldestPerson = null;
        for (AddressBookRecord addressBookRecord : records) {
            if (null == oldestPerson) {
                oldestPerson = addressBookRecord;
                continue;
            }
            if (addressBookRecord.getDob().before(oldestPerson.getDob())) {
                oldestPerson = addressBookRecord;
            }
        }
        return oldestPerson;
    }

    /**
     * Returns the difference in number of days between the date of birth of record 1 and that of record 2. Note
     * that the value returned might be negative.
     * @param addressBookRecord1 {@link AddressBookRecord} record 1.
     * @param addressBookRecord2 {@link AddressBookRecord} record 2.
     * @return Difference in days.
     */
    public int daysDifference(AddressBookRecord addressBookRecord1, AddressBookRecord addressBookRecord2) {
        DateTime record1Date = new DateTime(addressBookRecord1.getDob());
        DateTime record2Date = new DateTime(addressBookRecord2.getDob());
        return Days.daysBetween(record1Date, record2Date).getDays();
    }

    /**
     * Days difference as String utility.
     * @param addressBookRecord1 {@link AddressBookRecord} record 1.
     * @param addressBookRecord2 {@link AddressBookRecord} record 2.
     * @return String description of the difference.
     */
    public String daysDifferenceAsString(AddressBookRecord addressBookRecord1, AddressBookRecord addressBookRecord2) {
        DateTime record1Date = new DateTime(addressBookRecord1.getDob());
        DateTime record2Date = new DateTime(addressBookRecord2.getDob());
        int days = Days.daysBetween(record1Date, record2Date).getDays();
        return addressBookRecord1.getName() + " is " + days + " " + (days > 0 ? "older" : "younger") + " than " + addressBookRecord2.getName();
    }

    /**
     * Find a record by name. The method is case-insensitive but a complete match is required.
     * @param name Name of record to be searched.
     * @return Record match by name. Null if we do not have a match.
     */
    public AddressBookRecord findByName(String name) {
        // Assuming that we will have only one entry per name, return the first one.
        for (AddressBookRecord addressBookRecord : records) {
            if (addressBookRecord.getName().toUpperCase().equals(name.toUpperCase())) {
                return addressBookRecord;
            }
        }
        return null;
    }
}
