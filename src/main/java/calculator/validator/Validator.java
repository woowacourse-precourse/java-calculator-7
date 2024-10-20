package calculator.validator;

import calculator.constants.StringConst;
import calculator.utils.ExceptionUtils;

public interface Validator {

    default void validate(int number) {
        if (number <= 0) {

            ExceptionUtils.throwInvalidNumberException();
        }
    }


    default boolean isHaveNextToken(String input) {
        if (input.split(StringConst.LINE_SEPARATOR_REGEX).length == 1) {
            ExceptionUtils.throwNotHaveNextTokenException();
            // throw new IllegalArgumentException("[ERROR] NextToken의 입력값이 없습니다");
        }

        return true;
    }


    public String canParseToNumber(String input);


}
