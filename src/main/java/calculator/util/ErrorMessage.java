package calculator.util;

public interface ErrorMessage {
    String INVALID_POSITIVE_NUMBER = "양수만 입력해주세요";
    String INVALID_DIGIT = "숫자만 입력해주세요";
    String INVALID_CUSTOM_DELIMITER = "커스텀 구분자를 입력해주세요.";
    String INVALID_FORMAT = "형식에 맞춰서 입력해주세요";
    String DUPLICATE_DELIMITER = "이미 추가한 구분자는 custom으로 지정할 수 없습니다.";
}
