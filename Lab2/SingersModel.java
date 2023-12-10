import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingersModel {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/musicdb";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public void insertSinger(String name, String surname, String pseudonym) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO singers (idSingers, Name, Surname, Pseudonym) VALUES (DEFAULT, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, surname);
                statement.setString(3, pseudonym);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getSingers() {
        List<String> singersList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM singers";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String singerInfo = resultSet.getString("Name") + " " +
                                resultSet.getString("Surname") + " (" +
                                resultSet.getString("Pseudonym") + ")";
                        singersList.add(singerInfo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return singersList;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
