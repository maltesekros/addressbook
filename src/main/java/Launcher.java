import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by cmicallef on 27/05/2014.
 */
public class Launcher {

    /**
     * Main method for launching application.
     * @param args
     */
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        AddressBook addressBook = new AddressBook();
        // Load Address Book from file
        InputStream is = Launcher.class.getResourceAsStream("/AddressBook");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                createAddressBookRecord(simpleDateFormat, addressBook, line);
            }
            // Now call methods
            performTests(addressBook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // Nothing we can do here ...
                }
            }
        }
    }

    private static void performTests(AddressBook addressBook) {
        // Question 1.
        System.out.println("Males in address book => " + addressBook.getNumberOfMalesInAddressBook());
        // Question 2.
        System.out.println("Oldest Person => " + addressBook.getNameOfOldestPerson().getName());
        AddressBookRecord bill = addressBook.findByName("Bill McKnight");
        AddressBookRecord paul = addressBook.findByName("Paul Robinson");
        // Question 3.s
        System.out.println("Bill is older than Paul (in days) => " + addressBook.daysDifference(bill, paul));
    }

    private static void createAddressBookRecord(SimpleDateFormat simpleDateFormat, AddressBook addressBook, String line) throws ParseException {
        System.out.printf("Parsing line [%s]%n", line);
        StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
        String name = stringTokenizer.nextToken().trim();
        String gender = stringTokenizer.nextToken().trim();
        String dobStr = stringTokenizer.nextToken().trim();
        AddressBookRecordGender addressBookRecordGender = gender.toUpperCase().equals("MALE") ? AddressBookRecordGender.M : AddressBookRecordGender.F;
        Date dob = simpleDateFormat.parse(dobStr);
        AddressBookRecord addressBookRecord = new AddressBookRecord(name, dob, addressBookRecordGender);
        addressBook.addAddressBookRecord(addressBookRecord);
    }

}
