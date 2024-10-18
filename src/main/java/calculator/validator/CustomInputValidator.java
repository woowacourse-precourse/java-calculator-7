package calculator.validator;

import calculator.error.ErrorCode;
import java.util.ArrayList;
import java.util.List;

public class CustomInputValidator implements InputValidator{
  @Override
  public void validateInput(String input){
    if(input == null){
      throw new IllegalArgumentException(ErrorCode.NULL_INPUT.toString());
    }
    if (!input.isEmpty() && input.trim().isEmpty()) {
      throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.toString());
    }
    if(input.startsWith("//")){
      char customDelimiter = extractCustomDelimiter(input);
//      validateAllowedCharacters(input.substring(4), customDelimiter);
    }
//    else{
//      validateAllowedCharacters(input, ',');
//    }
  }

  private char extractCustomDelimiter(String input) {
    int endIdx = input.indexOf("\n");
    if(endIdx == -1){
      throw new IllegalArgumentException(ErrorCode.CUSTOM_DELIMITER_FORMAT_ERROR.toString());
    }
    else if(endIdx != 3){
      throw new IllegalArgumentException(ErrorCode.CUSTOM_DELIMITER_LENGTH_ERROR.toString());
    }

    char delimiter = input.charAt(2);
    if(Character.isDigit(delimiter) || delimiter == '.' || delimiter == 'e' || delimiter == 'E' || delimiter == '-'){
      throw new IllegalArgumentException(ErrorCode.INVALID_DELIMITER_ERROR.toString());
    }
    return delimiter;
  }

//  private void validateAllowedCharacters(String input, char customDelimiter) {
//    List<Character> invalidChars = new ArrayList<>();
//    for (char ch : input.toCharArray()) {
//      if(!Character.isDigit(ch) && ch != customDelimiter && ch != ',' && ch != ':'){
//        invalidChars.add(ch);
//      }
//    }
//
//    if (!invalidChars.isEmpty()) {
//      throw new IllegalArgumentException(
//          ErrorCode.DISALLOWED_CHAR_ERROR.formatMessage(invalidChars.toString()));
//    }
//  }
}
