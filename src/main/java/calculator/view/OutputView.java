package calculator.view;

public class OutputView {
    private static final String INPUT_CALCULATION_STRING = "덧셈할 문자열을 입력해 주세요.";

    private OutputView() {
    }

    public static void printCalculationInputMessage() {
        System.out.println(INPUT_CALCULATION_STRING);
    }

}
