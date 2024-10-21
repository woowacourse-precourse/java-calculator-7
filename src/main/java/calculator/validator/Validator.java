package calculator.validator;

import java.util.List;

public class Validator {
    private static final String DELIMETER_START = "//";
    private static final String DELIMETER_END = "\\n";
    private static final String SEPERATOR_COLON = ":";
    private static final String SEPERATOR_COMMA = ",";
    private static final String SEQUENCE_REGEX = ".*\\D{2,}.*";
    public void validateCustomSeperator(String inputString) {
        if (!inputString.contains(DELIMETER_END)) {
            throw new IllegalArgumentException("'\\n'로 커스텀 구분자를 지정해야 합니다.");
        }

        int delimiterStart = inputString.indexOf(DELIMETER_START) + 2;
        int delimiterEnd = inputString.indexOf(DELIMETER_END);
        String delimiter = inputString.substring(delimiterStart, delimiterEnd);

        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("'//'와 '\\n' 사이에 하나의 구분자만 있어야 합니다.");
        }

        if (delimiter.isEmpty() || delimiter.trim().isEmpty()) {
            throw new IllegalArgumentException("'//'와 '\\n' 사이에 구분자가 있어야 합니다.");
        }

        if (delimiter.equals(SEPERATOR_COMMA) || delimiter.equals(SEPERATOR_COLON)) {
            throw new IllegalArgumentException("구분자로 쉼표(,) 또는 콜론(:)은 사용할 수 없습니다.");
        }
    }

    public void validateNumber(List<Integer> list) {
        if (!list.stream().allMatch(number -> number > 0)) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }

    public void validateSeperator(String Regex, String inputString) {
        if (inputString.matches(Regex)) {
            throw new IllegalArgumentException("쉼표(,) 또는 콜론(:) 또는 커스텀 구분자가 아닌 다른 구분자는 사용할 수 없습니다.");
        }

        if (inputString.matches(SEQUENCE_REGEX)) {
            throw new IllegalArgumentException("구분자를 연속으로 작성할 수 없습니다.");
        }
    }
}
