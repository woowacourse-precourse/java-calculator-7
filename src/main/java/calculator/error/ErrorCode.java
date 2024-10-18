package calculator.error;

public enum ErrorCode{
  NULL_INPUT("IV-001", "입력값이 null입니다."),
  CUSTOM_DELIMITER_FORMAT_ERROR("IV-002", "커스텀 구분자 형식 오류: '\\n'이 필요합니다."),
  CUSTOM_DELIMITER_LENGTH_ERROR("IV-003", "구분자는 한 글자여야 합니다."),
  INVALID_DELIMITER_ERROR("IV-004", "커스텀 구분자 내용 오류: 숫자('0-9'), '.', 'e', 'E'는 사용할 수 없습니다."),
  DISALLOWED_CHAR_ERROR("IV-005", "허용되지 않는 문자: %s가 포함되어 있습니다.");

  private final String code;
  private final String message;

  ErrorCode(String code, String message){
    this.code = code;
    this.message = message;
  }

  public String formatMessage(Object... args){
    return code + ": " + String.format(message, args);
  }

  @Override
  public String toString(){
    return code + ": " + message;
  }
}

