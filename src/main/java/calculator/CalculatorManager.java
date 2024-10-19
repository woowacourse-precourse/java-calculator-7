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

    public int sum(String[] numbers) {
        try {
            return Arrays.stream(numbers)   // Stream<String>
                    .map(this::toPositive)  // Stream<Integer>
                    .reduce(Integer::sum)   // Optional<Integer>
                    .orElseThrow();         // 존재하지 않으면 예외처리
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 포함되어 있습니다.", e);
        }
    }
    private int toPositive(String number) {
        int num = Integer.parseInt(number.strip());
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }

}
