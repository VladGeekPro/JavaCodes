import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/basketball_knowledge_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM questions";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int questionId = resultSet.getInt("question_id");
                        String questionText = resultSet.getString("question_text");
                        questions.add(new Question(questionId, questionText));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public List<Answer> getAnswersForQuestion(int questionId) {
        List<Answer> answers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM answers WHERE question_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, questionId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int answerId = resultSet.getInt("answer_id");
                        String answerText = resultSet.getString("answer_text");
                        boolean isCorrect = resultSet.getBoolean("is_correct");
                        answers.add(new Answer(answerId, answerText, isCorrect));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answers;
    }
}
