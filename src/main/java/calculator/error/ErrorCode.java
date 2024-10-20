package calculator.error;

public enum ErrorCode {
  //입력 유효성 검증(Input Validator) 에러
  NULL_INPUT("IV-001", "입력값이 null입니다."),
  EMPTY_INPUT("IV-002", "입력값이 공백입니다."),
  CUSTOM_DELIMITER_FORMAT_ERROR("IV-002", "커스텀 구분자 형식 오류: '\\n'이 필요합니다."),
  CUSTOM_DELIMITER_LENGTH_ERROR("IV-003", "구분자는 한 글자여야 합니다."),
  INVALID_DELIMITER_ERROR("IV-004", "커스텀 구분자 내용 오류: 숫자('0-9'), '.', '-', 'e', 'E'는 사용할 수 없습니다."),

  //숫자 유효성 검증(Number Validator)에러
  EMPTY_NUMBER_ERROR("NV-001", "구분자 사이에 숫자가 입력되어야 합니다."),
  NEGATIVE_NUMBER_ERROR("NV-002", "음수는 허용되지 않습니다"),
  INVALID_NUMBER_FORMAT("NV-003", "양수, 소수 또는 과학적 표기법 형식의 숫자로 입력해야 합니다.");

  private final String code;
  private final String message;

  ErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

//  public String formatMessage(Object... args){
//    return code + ": " + String.format(message, args);
//  }

  @Override
  public String toString() {
    return code + ": " + message;
  }
}

