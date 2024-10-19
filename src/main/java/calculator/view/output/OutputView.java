package calculator.view.output;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    private OutputView() {
    }

    public static void printResult(int result) {
        printMessage(RESULT_MESSAGE + result);
    }
    
    private static void printMessage(String message) {
        System.out.println(message);
    }
}
