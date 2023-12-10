import java.util.List;

public class Main {
    public static void main(String[] args) {
        SingersModel singersModel = new SingersModel();
        SingersView singersView = new SingersView(singersModel);

        // Example: Inserting a new singer into the database
        singersModel.insertSinger("Nike", "Wild", "NW");

        // Example: Retrieving and printing the list of singers
        List<String> singersList = singersModel.getSingers();
        for (String singerInfo : singersList) {
            System.out.println(singerInfo);
        }

        // Launching the view
        singersView.start();  // This will start the interaction with the user through the console
    }
}
