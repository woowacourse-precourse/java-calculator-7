package calculator.view;

public class OutputView {
    public static final String START_CALCULATOR = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT = "결과 : ";

    public static void displayStart() {
        OutputWriter.displayMessage(START_CALCULATOR);
    } // displayStart

    public static void displayResult(int result) {
        OutputWriter.displayMessage(RESULT + result);
    } // displayResult
} // class