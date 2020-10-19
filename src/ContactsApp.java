import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ContactsApp {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String directoryName = "Contacts_Manager_App";
        String fileName = "contacts.txt";
        boolean toStartAgain;
        boolean toKeepAdding;

        Contacts.printMenu();

        Path dataFilePath = Contacts.createDirectoryAndFile(directoryName, fileName);
        Contacts contact = new Contacts();
//        contact.addContacts(dataFilePath);

//        contact.printFileContents(dataFilePath);
//        contact.deleteContact(dataFilePath);

        contact.printFileContents(dataFilePath);

        try {
            System.out.println("\n"+"Welcome to your contacts manager. What would you like to do?"+"\n");
            do {
                Contacts.printMenu();
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1:
                        Contacts.printFileContents(dataFilePath);
                        break;
                    case 2:
                        do {
                            Contacts newContact = new Contacts();
                            contact.addContacts(dataFilePath);
                            toKeepAdding = Contacts.yesNo("Would you like to add another?");
                        }while(toKeepAdding);
                        break;
                    case 3:
                        Contacts.searchContact(dataFilePath);
                        break;
                    case 4:
                        Contacts.deleteContact(dataFilePath);
                        Contacts.printFileContents(dataFilePath);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
                toStartAgain = Contacts.yesNo("Would you like to see the menu again?");
            } while (toStartAgain);
        } catch (IOException ioex) {
            System.out.println("Error");
        }

    }

}
