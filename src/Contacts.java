import java.nio.file.Path;

public class Contacts {

    public static void printMenu(){
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5): ");
    }
//      ViewContacts Method
    public static void printViewContents(Path filePath) {
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

}
