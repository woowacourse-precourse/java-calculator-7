package calculator.view;

public class OutputView {
    private static final String ASK_FOR_STRING_TO_CALCULATE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : %d";

    public void askForStringToCalculate() {
        System.out.println(ASK_FOR_STRING_TO_CALCULATE);
    }

    public void printResult(int result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}
