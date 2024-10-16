package calculator.view;

public class OutputView {
    private static final String OUTPUT_RESULT = "결과 : ";

    public static void printResult(int sum) {
        System.out.println(OUTPUT_RESULT + sum);
    }
}
