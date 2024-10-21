package calculator;

public class OutputPrinter {

    private static final String RESULT_MESSAGE_PREFIX = "결과 : ";

    public void displayResult(int result) {
        System.out.println(RESULT_MESSAGE_PREFIX + result);
    }

    public void displayError(String message) {
        System.out.println("에러: " + message);
    }
}
