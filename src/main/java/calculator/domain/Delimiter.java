package calculator.domain;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private final Set<Character> delimiterSet;
    private static final String CUSTOM_FORMAT_ERROR = "커스텀 구분자는 '//'와 '\\n' 사이의 문자로 입력 가능합니다.";
    private static final String INVALID_CUSTOM_DELIMITER = "커스텀 구분자는 반드시 하나의 문자로 구성되어야 합니다.";

    // 기본 구분자는 생성자 호출 시에 추가
    public Delimiter() {
        this.delimiterSet = new HashSet<>();
        this.delimiterSet.add(',');
        this.delimiterSet.add(':');
    }

    // 구분자를 추가하는 메서드
    public void addDelimiter(char delimiter) {
        // 커스텀 구분자 입력 시에 숫자가 입력될 경우 예외 발생 코드 추가
        delimiterSet.add(delimiter);
    }

    // 구분자를 확인하고 구분자와 숫자로 된 문자열을 반환하는 메서드
    public String[] changeInputLine(String input) {
        String numberLine = validateFormat(input);
        return splitToNumbersArray(numberLine);
    }

    // 구분자 집합을 사용해서 split 메서드 사용을 위한 regex를 생성하는 메서드
    private String setRegex() {
        StringBuilder sb = new StringBuilder("[");
        for (Character c : delimiterSet) {
            sb.append(c);
        }
        sb.append("]");
        return sb.toString();
    }


    // 입력받은 문자열을 split 메서드를 사용해서 구분자를 기준으로 나누는 메서드
    public String[] splitToNumbersArray(String input) {
        return input.split(setRegex());
    }

    private String validateFormat(String input) {
        if (input.startsWith("//")) {
            // 구분자의 입력 format을 검증하고 예외 발생
            int index = input.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException(CUSTOM_FORMAT_ERROR);
            }

            // 커스텀 구분자가 1개 이상의 문자라면 예외 발생
            String customLine = input.substring(2, index);
            if (customLine.length() != 1) {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
            }

            // 커스텀 구분자가 숫자라면 예외 발생
            char customDelimiter = customLine.charAt(0);
            if (customDelimiter >= '0' && customDelimiter <= '9') {
                throw new IllegalArgumentException(INVALID_CUSTOM_DELIMITER);
            }

            // 예외가 발생하지 않으면 구분자로 추가
            addDelimiter(customDelimiter);
            return input.substring(index + 2);
        }

        // 커스텀 구분자가 없을 경우
        return input;
    }
}
