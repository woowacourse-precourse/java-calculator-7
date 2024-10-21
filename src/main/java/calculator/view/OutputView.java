package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";
    private static final String ERROR_MESSAGE = "오류: " ;
    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }

    public void printError(String message) {
        System.out.println(ERROR_MESSAGE+ message);
    }
}
