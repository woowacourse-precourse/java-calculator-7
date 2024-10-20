package calculator.view;

public class OutputView {
    private static final String INPUT_CALCULATION_STRING = "덧셈할 문자열을 입력해 주세요.";
    private static final String EXECUTION_RESULT = "결과 : ";

    private OutputView() {
    }

    public static void printCalculationInputMessage() {
        System.out.println(INPUT_CALCULATION_STRING);
    }

    public static void printExecutionResultMessage(Long result) {
        System.out.println(EXECUTION_RESULT + result);
    }

}
