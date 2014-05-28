import java.util.Date;

/**
 * Created by cmicallef on 27/05/2014.
 */
public final class AddressBookRecord {

    private final String name;

    private final Date dob;

    private final AddressBookRecordGender gender;

    /**
     * Constructor for immutable class. The record will not be changeable programatically.
     * @param name Name and Surname.
     * @param dob Date of Birth.
     * @param gender Gender.
     */
    public AddressBookRecord(String name, Date dob, AddressBookRecordGender gender) {
        if (name == null || dob == null || gender == null) {
            throw new IllegalArgumentException("One or more parameters is null. Cannot create instance. ");
        }
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public AddressBookRecordGender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "AddressBookRecord{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                '}';
    }
}
