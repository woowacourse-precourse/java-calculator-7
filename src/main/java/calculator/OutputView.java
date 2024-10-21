package calculator;

public class OutputView {
    public static final String PRINT_RESULT_MESSAGE = "결과 : ";

    void printResult(long result) {
        System.out.println(PRINT_RESULT_MESSAGE + result);
    }
}
