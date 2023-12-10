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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение вопросов из базы данных
        List<Question> questions = databaseHandler.getQuestions();

        // Установка атрибута для передачи данных на JSP-страницу
        request.setAttribute("questions", questions);

        // Перенаправление на JSP-страницу
        RequestDispatcher dispatcher = request.getRequestDispatcher("/quiz.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Обработка ответов от пользователя
        // Логика проверки правильности ответов и обновления данных в базе данных

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

