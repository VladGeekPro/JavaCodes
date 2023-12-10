public class Answer {
    private int answerId;
    private String answerText;
    private boolean isCorrect;

    public Answer(int answerId, String answerText, boolean isCorrect) {
        this.answerId = answerId;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    // Getter methods for answerId, answerText, and isCorrect
    public int getAnswerId() {
        return answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
