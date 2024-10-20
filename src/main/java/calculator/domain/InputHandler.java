package calculator.domain;

import static calculator.utils.Parse.buildMultiDelimiterFromSet;
import static calculator.utils.Parse.splitUserInputTowPart;
import static calculator.utils.Validator.validateCustomDelimiter;

import java.util.*;


public class InputHandler {
    private final Set<String> delimiters = new HashSet<>(Arrays.asList(",", ":"));
    private final List<Double> numbers;

    public InputHandler(String input) {
        List<String> inputParts = splitUserInputTowPart(input);
        addCustomDelimiter(inputParts);
        numbers = parseStringToNumbers(inputParts.get(inputParts.size() - 1));
    }

    private void addCustomDelimiter(List<String> parsedUserInput) {
        if (parsedUserInput.size() != 2) {
            return;
        }

        String customDelimiter = parsedUserInput.get(0).trim(); // "//" 이후의 구분자 가져오기
        validateCustomDelimiter(customDelimiter);
        delimiters.add(customDelimiter);
    }


    private List<Double> parseStringToNumbers(String numberString) {
        if (numberString.isEmpty()) {
            return Collections.emptyList();
        }
        String delimiterPattern = buildMultiDelimiterFromSet(delimiters);

        return Arrays.stream(numberString.split(delimiterPattern))
            .filter(s -> !s.isEmpty()) // 빈 문자열 필터링
            .map(this::convertToDouble)
            .toList();
    }

    private Double convertToDouble(String number) {
        if (number == null || number.trim().isEmpty()) {
            return 0.0; // 빈 문자열의 경우 0으로 처리
        }
        try {
            return Double.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자의 형식이 아닙니다");
        }
    }


    public List<Double> getParsedNumbers() {
        return new ArrayList<>(numbers);
    }
}
