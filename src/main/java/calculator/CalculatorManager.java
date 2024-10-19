package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class CalculatorManager {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SURFIX = "\\n";
    private static final String DEFUALT_DELIMITER = "[,:]";

    String[] numbers;

    public int calculate(String input){
        if (input == null || input.isBlank()){
            return 0;
        }
        String[] numbers = split(input);
        return sum(numbers);
    }

    private String[] split(String input){
        // 기본 구분자
        if (!hasCustomDelimiter(input)){
            return numbers = input.split(DEFUALT_DELIMITER);
        }

        //커스텀 구분자
        int customIndex = input.indexOf(CUSTOM_DELIMITER_SURFIX);
        if (customIndex == -1){
            throw new IllegalArgumentException("커스텀 구분자가 입력 양식이 잘못되었습니다..");
        }
        // 커스텀 구분자 추출
        String customDelimiter = input.substring(2, customIndex);
        if (customDelimiter.isBlank()){
            throw new IllegalArgumentException("커스텀 구분자는 공백일 수 없습니다.");
        }
        // 구분자 이후 숫자들 추출
        String numberString = input.substring(customIndex + CUSTOM_DELIMITER_SURFIX.length());
        String escapedDelimiter = Pattern.quote(customDelimiter);
        return numberString.split(escapedDelimiter);
    }


    private boolean hasCustomDelimiter(String input){
        boolean condition = input.startsWith(CUSTOM_DELIMITER_PREFIX);
        int suffixIndex = input.indexOf(CUSTOM_DELIMITER_SURFIX);
        if (condition && suffixIndex == -1){
            throw new IllegalArgumentException("커스텀 구분자가 유효하지 않습니다.");
        }

        condition &= suffixIndex >= CUSTOM_DELIMITER_PREFIX.length() + 1;
        return condition;
    }



}
