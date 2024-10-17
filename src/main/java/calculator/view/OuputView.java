package calculator.view;

public class OuputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printResult(int result) {
        System.out.print(RESULT_MESSAGE + result);
    }
}
