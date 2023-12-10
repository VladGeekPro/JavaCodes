<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basketball Knowledge Quiz</title>
    <!-- Добавьте стили по желанию -->
</head>
<body>

<h1>Basketball Knowledge Quiz</h1>

<form id="quizForm" action="/quiz" method="post">
    <!-- Вопросы и варианты ответов -->
    <c:forEach var="question" items="${questions}">
        <p>${question.questionText}</p>
        <c:forEach var="answer" items="${question.answers}">
            <input type="radio" name="question${question.questionId}" value="${answer.answerId}"> ${answer.answerText}<br>
        </c:forEach>
        <br><hr>
    </c:forEach>

    <!-- Кнопка отправки формы -->
    <input type="submit" value="Submit">
</form>

</body>
</html>
