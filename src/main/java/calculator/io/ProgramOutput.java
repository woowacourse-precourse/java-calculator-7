package calculator.io;

import calculator.Calculator;

public class ProgramOutput {
    private static final String REQUEST_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String GUIDE_RESULT_MESSAGE = "결과 : ";

    public void requestString() {
        System.out.println(REQUEST_STRING_MESSAGE);
    }

    public void printCalculateResult(String inputString) {
        System.out.print(GUIDE_RESULT_MESSAGE);
    }


}
