package calculator.view;

public enum Output {
    START_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_MESSAGE("결과 : %d");

    final String message;

    Output(String message) {
        this.message = message;
    }

}
