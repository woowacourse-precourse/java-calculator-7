package calculator;

public class OutputView {

    private static final String RESULT_MESSAGE = "결과 : %d";
    public void print(long result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}
