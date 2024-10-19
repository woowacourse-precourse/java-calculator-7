package calculator.view;

public class OutputView {
    private static final String OUTPUT_VIEW = "결과 : ";

    public static void showOutput(Long output) {
        System.out.println(OUTPUT_VIEW + output);
    }
}
