package calculator.view;

public class OutputView {

  private static final String RESULT_MESSAGE = "결과 : ";
  private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

  public void printInputMessage() {
    System.out.println(INPUT_PROMPT);
  }

  public void printResultMessage(int result) {
    System.out.println(RESULT_MESSAGE + result);
  }
}