import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private DatabaseHandler databaseHandler;

    @Override
    public void init() {
        // Инициализация экземпляра DatabaseHandler
        databaseHandler = new DatabaseHandler();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Получение вопросов из базы данных
        List<Question> questions = databaseHandler.getQuestions();

        // Вывод HTML-формы с вопросами
        out.println("<html>");
        out.println("<head><title>Quiz Form</title></head>");
        out.println("<body>");
        out.println("<h1>Quiz Form</h1>");

        // Отображение вопросов и формы

        for (Question question : questions) {
            out.println("<p>" + question.getQuestionText() + "</p>");
            out.println("<form method=\"post\" action=\"/quiz\">");
            out.println("<input type=\"hidden\" name=\"questionId\" value=\"" + question.getQuestionId() + "\">");

            // Отображение вариантов ответов
            for (Answer answer : question.getAnswers()) {
                out.println("<input type=\"radio\" name=\"selectedAnswerId\" value=\"" + answer.getAnswerId() + "\"> " +
                            answer.getAnswerText() + "<br>");
            }

            out.println("<br><hr>");
        }

        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Обработка ответов от пользователя
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        int selectedAnswerId = Integer.parseInt(request.getParameter("selectedAnswerId"));

        // Логика проверки правильности ответа и обновления данных в базе данных

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Quiz Result</title></head>");
        out.println("<body>");
        out.println("<h1>Quiz Result</h1>");
        out.println("<p>Your quiz responses have been submitted. Check the results on the server side logic.</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void destroy() {
        // Закрытие ресурсов при завершении работы сервлета
        databaseHandler.close();
    }
}
