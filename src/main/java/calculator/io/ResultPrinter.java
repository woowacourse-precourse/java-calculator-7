package calculator.io;

public class ResultPrinter {

    private static final String RESULT_MESSAGE_FORMAT = "결과 : %d";

    public void printResult(int result) {
        System.out.println(RESULT_MESSAGE_FORMAT.formatted(result));
    }
}
