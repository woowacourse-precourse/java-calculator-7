package calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputParser {
    public void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Error: 문자열은 null이 될수 없습니다.");
        }
        if (input.matches(".*\".*\".*")) {
            throw new IllegalArgumentException("Error: 하나의 문자열만 입력해야 합니다.");
        }
    }
    public String processSpace(String input) {
        return input.trim();
    }
    public List<Integer> parse(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (input.isEmpty()) {
            numbers.add(0);
            return numbers;
        }
        String customDelimiter = extractCustomDelimiter(input);
        if (!customDelimiter.isEmpty()) {
            input = input.substring(input.indexOf('\n') + 1);
        }
        String[] splitInput = splitInputByDelimiter(input, customDelimiter);
        return convertToIntegerList(splitInput);
    }
    private String extractCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            if (input.length() < 4 || input.charAt(3) != '\n') {
                throw new IllegalArgumentException("Error: 커스텀 구분자의 형식이 잘못되었습니다.");
            }
            return Pattern.quote(input.substring(2, input.indexOf('\n')));
        }
        return "";
    }
    private String[] splitInputByDelimiter(String input, String customDelimiter) {
        return customDelimiter.isEmpty() ? input.split("[,:]") : input.split(customDelimiter);
    }
    private List<Integer> convertToIntegerList(String[] splitInput) {
        List<Integer> integerList = new ArrayList<>();
        for (String s : splitInput) {
            if (!s.matches("\\d+")) {
                throw new IllegalArgumentException("Error: 입력 값은 숫자여야 합니다.");
            }
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new IllegalArgumentException("Error: 입력 값은 음수가 될 수 없습니다.");
            }
            integerList.add(number);
        }
        return integerList;
    }
}
