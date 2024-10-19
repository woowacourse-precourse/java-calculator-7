package calculator.exception.delimiter;

public enum DelimiterExceptionMessage {

    WRONG_CUSTOM_DELIMITER_FORMAT("잘못된 커스텀 구분자 형식입니다."),
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자를 입력하지 않으셨습니다.");

    final String message;

    DelimiterExceptionMessage(String message) {
        this.message = message;
    }
}
