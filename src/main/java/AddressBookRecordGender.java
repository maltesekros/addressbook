/**
 * Created by cmicallef on 27/05/2014.
 */
public enum AddressBookRecordGender {

    M("Male"),

    F("Female");

    private String gender;

    AddressBookRecordGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
