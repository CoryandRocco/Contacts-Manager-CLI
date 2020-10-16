
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    Scanner scanner = new Scanner(System.in);
    String firstName;
    String lastName;
    String phoneNumber;

    public Contacts() {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void printMenu(){
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5): ");
    }

    //CREATE DIRECTORY & FILE
    public static Path createDirectoryAndFile(String directoryName, String fileName) throws IOException{
        Path directoryPath = Paths.get(directoryName);
        Path dataFilePath = Paths.get(directoryName, fileName);

        //We have to create a directory first before we create before we create the file.

        if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        if (!Files.exists(dataFilePath)) {
            Files.createFile(dataFilePath);
        }

        return dataFilePath;
    }

    //PRINT CONTACT LIST
    public static void printFileContents(Path filePath) throws IOException {
//        System.out.println();
//        List<String> fileContents = Files.readAllLines(filePath);
//        for (int i = 0; i < fileContents.size(); i++) {
//            System.out.printf("%s\n", fileContents.get(i));
//        }
        // Create a header
        String header = "Name            | " + "Phone Number   | " + "\n"
                +   "----------------------------------" + "\n";
//        System.out.format("%-15s", header);
        System.out.format("%-10s", header);

        List<String> fileContents = Files.readAllLines(filePath);

        for (String fileContent : fileContents) {
            System.out.printf("%-10s", fileContent);
        }

    }


    //ADD A CONTACT TO CONTACTS LIST
    public void addContacts(Path filePath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact");
        this.firstName = scanner.nextLine();
        System.out.println("Please enter the last name of the contact");
        this.lastName = scanner.nextLine();
        System.out.println("Please enter the phone number of the contact");
        this.phoneNumber = scanner.nextLine();
        List<String> contactsList = Arrays.asList(firstName + " " + lastName + " | " + phoneNumber + "\n");
        Files.write(filePath, contactsList, StandardOpenOption.APPEND);
    }

    //DELETE CONTACT

    public void deleteContact(Path filePath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name of the contact you would like to delete.");
        String firstNameDelete = scanner.nextLine();
        System.out.println("Please enter the last name of the contact you would like to delete.");
        String lastNameDelete = scanner.nextLine();
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();

        for (String contact: fileContents) {
            if(!contact.contains(firstNameDelete+lastNameDelete)) {
                modifiedList.add(contact);
            }
        }
        Files.write(filePath, modifiedList);
    }


}
