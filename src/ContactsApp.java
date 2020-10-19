import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ContactsApp {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String directoryName = "Contacts_Manager_App";
        String fileName = "contacts.txt";

        Contacts.printMenu();

        Path dataFilePath = Contacts.createDirectoryAndFile(directoryName, fileName);
        Contacts contact = new Contacts();
//        contact.addContacts(dataFilePath);

//        contact.printFileContents(dataFilePath);
//        contact.deleteContact(dataFilePath);
        contact.searchContact(dataFilePath);

        contact.printFileContents(dataFilePath);


    }

}
