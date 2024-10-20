package calculator.validator;

import calculator.error.ErrorCode;
import java.util.regex.Pattern;

public class BasicNumberValidator implements NumberValidator {

  private static final Pattern NUMBER_PATTERN = Pattern.compile(
      "^[0-9]+(\\.[0-9]+)?([eE][+-]?[0-9]+)?$"
  );
  @Override
  public void validateNumber(String token){
    if(token.isEmpty()){
      throw new IllegalArgumentException(ErrorCode.EMPTY_NUMBER_ERROR.toString());
    }

    if(token.startsWith("-")){
      throw new IllegalArgumentException(ErrorCode.NEGATIVE_NUMBER_ERROR.toString());
    }

    if(!isNumeric(token)){
      throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_FORMAT.toString());
    }
  }

  private boolean isNumeric(String token) {
    return NUMBER_PATTERN.matcher(token).matches();
  }
}
