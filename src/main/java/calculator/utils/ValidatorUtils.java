package calculator.utils;

import java.util.List;

import static calculator.constant.ExceptionConstant.*;

public class ValidatorUtils {

    public static void validateNumbers(List<Double> numbers){
        for (Double number : numbers) {
            if(number <= 0){
                throw new IllegalArgumentException(NUMBER_NOT_POSITIVE_EXCEPTION);
            }
        }
    }

    public static void validateCustomDelimiter(String customDelimiter){
        if(customDelimiter.length() != 1 || Character.isDigit(customDelimiter.charAt(0))){
            throw new IllegalArgumentException(CUSTOM_DELIMITER_EXCEPTION);
        }
    }
}
