package calculator.validator;

public class CustomInputValidator implements InputValidator{
  @Override
  public void validateInput(String input){
    if(input == null){
      throw new IllegalArgumentException("입력값이 null입니다.");
    }

    if(input.startsWith("//")){
      char customDelimiter = extractCustomDelimiter(input);
      validateAllowedCharacters(input.substring(input.indexOf("\n") + 1), customDelimiter);
    }
    else{
      validateAllowedCharacters(input, ',');
    }
  }

  private char extractCustomDelimiter(String input) {
    if(!input.contains("\n")){
      throw new IllegalArgumentException("커스텀 구분자 형식 오류: '\\n'이 필요합니다.");
    }

    char delimiter = input.charAt(2);
    if(Character.isDigit(delimiter) || delimiter == '.' || delimiter == 'e' || delimiter == 'E'){
      throw new IllegalArgumentException("커스텀 구분자 내용 오류: 숫자('0-9'), '.', 'e', 'E'는 사용할 수 없습니다.");
    }
    return delimiter;
  }

  private void validateAllowedCharacters(String input, char customDelimiter) {
    for (char ch : input.toCharArray()) {
      if(!Character.isDigit(ch) && ch != customDelimiter && ch != ',' && ch != ':'){
        throw new IllegalArgumentException("허용되지 않는 문자: " + ch + "가 포함되어 있습니다.");
      }
    }
  }
}
