package view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printResult(int sum) {
        String result = RESULT_MESSAGE + sum;
        System.out.println(result);
    }
}