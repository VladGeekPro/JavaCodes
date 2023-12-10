import java.util.Scanner;

public class SingersController {
    private SingersModel singersModel;
    private Scanner scanner;

    public SingersController(SingersModel singersModel) {
        this.singersModel = singersModel;
        this.scanner = new Scanner(System.in);
    }

    public void handleUserInput() {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Insert Singer");
            System.out.println("2. Show Singers");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    insertSinger();
                    break;
                case 2:
                    showSingers();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void insertSinger() {
        System.out.print("Enter singer's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter singer's surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter singer's pseudonym: ");
        String pseudonym = scanner.nextLine();

        singersModel.insertSinger(name, surname, pseudonym);
        System.out.println("Singer inserted successfully.");
    }

    private void showSingers() {
        System.out.println("List of Singers:");
        singersModel.getSingers().forEach(System.out::println);
    }
}
