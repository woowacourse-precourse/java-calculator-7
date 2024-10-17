package view;

public class OutputView {
    private static final String PRINT_READ_NUMBER_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String PRINT_CALCULATOR_RESULT_MESSAGE = "\n결과: ";

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printReadNumberMessage() {
        printMessage(PRINT_READ_NUMBER_MESSAGE);
    }

    public void printCalculatorResultMessage(String result) {
        printMessage(PRINT_CALCULATOR_RESULT_MESSAGE + result);
    }
}
