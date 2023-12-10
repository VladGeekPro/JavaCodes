public class Question {
  private int questionId;
  private String questionText;

  public Question(int questionId, String questionText) {
    this.questionId = questionId;
    this.questionText = questionText;
  }

  // Getter methods for questionId and questionText
  public int getQuestionId() {
    return questionId;
  }

  public String getQuestionText() {
    return questionText;
  }
}