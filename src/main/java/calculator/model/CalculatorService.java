package calculator.model;

import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final Pattern SPECIAL_CHARACTERS_REGEX = Pattern.compile("[?*+()\\[\\]{}.]");
    private static final String CUSTOM_DELIMITER_PREFIX = "\\n"; // \n를 그대로 사용하기 위함.

    private final ExtractLogic extractLogic = new ExtractLogic();
    private final CalculatorOperation calculatorOperation = new CalculatorOperation();
    private final ValidationUtils validationUtils = new ValidationUtils();

    public int calculate(String input) {
        String delimiter = getDelimiter(input);
        List<Integer> numbers = getNumbers(input, delimiter);
        validationUtils.numbersCheck(numbers);
        return calculatorOperation.calculateSum(numbers);
    }

    private String getDelimiter(String input) {
        String delimiter = extractLogic.extractDelimiter(input);
        return hasSpecialCharacters(delimiter) ? Pattern.quote(delimiter) : delimiter;
    }

    private List<Integer> getNumbers(String input, String delimiter) {
        String numbersInput;

        if (input.contains(CUSTOM_DELIMITER_PREFIX)) {
            // CUSTOM_DELIMITER_PREFIX가 있는 경우 그 뒤의 부분을 추출
            numbersInput = input.substring(input.indexOf(CUSTOM_DELIMITER_PREFIX) + 2);
        } else {
            // 그렇지 않은 경우 전체 input을 사용
            numbersInput = input;
        }

        // numbersInput에서 구분자를 사용하여 숫자 리스트를 추출
        return extractLogic.extractNumber(numbersInput, delimiter);
    }

    private boolean hasSpecialCharacters(String delimiter) {
        return SPECIAL_CHARACTERS_REGEX.matcher(delimiter).find();
    }
}
