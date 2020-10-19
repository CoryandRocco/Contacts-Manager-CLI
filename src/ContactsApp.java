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


        Path dataFilePath = Contacts.createDirectoryAndFile(directoryName, fileName);


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
                            newContact.addContacts(dataFilePath);
                            toKeepAdding = Contacts.yesNo("Would you like to add another?");
                        }while(toKeepAdding);
                        Contacts.printFileContents(dataFilePath);
                        break;
                    case 3:
                        Contacts.searchContact(dataFilePath);
                        break;
                    case 4:
                        Contacts.deleteContact(dataFilePath);
                        Contacts.printFileContents(dataFilePath);
                        break;
                    case 5:
                        System.out.println("Thank you for using Contacts Manager application, Have a fantastic day!");
                        System.exit(0);
                        break;
                }
                toStartAgain = Contacts.yesNo("Would you like to see the menu again?");
            } while (toStartAgain);
            System.out.println("Thank you for using Contacts Manager application, Have a fantastic day!");
        } catch (IOException ioex) {
            System.out.println("Error");
        }

    }

}
