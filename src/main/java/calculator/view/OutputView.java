package calculator.view;

import calculator.dto.AdditionResult;

public class OutputView {

    private static final String ADDITION_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String DEFAULT_RESULT = "결과 : 0";
    private static final String RESULT_MESSAGE = "결과 : ";


    private OutputView() {
    }

    public static void printAdditionInputPrompt() {
        System.out.println(ADDITION_PROMPT);
    }

    public static void printDefaultResult() {
        System.out.println(DEFAULT_RESULT);
    }

    public static void printResult(AdditionResult additionResult) {
        System.out.println(RESULT_MESSAGE + additionResult.result());
    }
}