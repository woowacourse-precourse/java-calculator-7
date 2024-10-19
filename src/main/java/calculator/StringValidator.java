package calculator;

import java.util.regex.Pattern;

import static calculator.Delimiter.PREFIX;
import static calculator.Delimiter.SUFFIX;

public class StringValidator {

    public void validate(String input) {

        if (hasDelimiterDeclaration(input)) {
            if (isCustomDelimiterMissing(input)) {
                throw new IllegalArgumentException("커스텀 구분자 선언부에 구분 기호가 누락되었습니다.");
            }
            if (isLengthExceeded(input)) {
                throw new IllegalArgumentException("구분자는 한 자리의 문자만 사용 가능합니다.");
            }
            if (hasNumberInDelimiter(input)) {
                throw new IllegalArgumentException("커스텀 구분자는 숫자를 제외한 문자만 사용 가능합니다.");
            }
            if (hasDelimiter(input)) {
                throw new IllegalArgumentException("이미 존재하는 구분자 입니다.");
            }
        }
        if (containsNonDelimiterCharacter(input)) {
            throw new IllegalArgumentException("구분자를 제외한 문자는 포함될 수 없습니다.");
        }
    }

    private boolean hasDelimiterDeclaration(String input) {
        return input.startsWith(PREFIX.value()) && input.contains(SUFFIX.value());
    }

    private boolean isCustomDelimiterMissing(String input) {
        return input.indexOf(PREFIX.value()) + 2 == input.indexOf(SUFFIX.value());
    }

    private boolean isLengthExceeded(String input) {
        return input.substring(2, input.indexOf(SUFFIX.value())).length() > 1;
    }

    private boolean hasNumberInDelimiter(String input) {
        char delimiter = input.charAt(2);
        return Character.isDigit(delimiter);
    }

    private boolean hasDelimiter(String input) {
        String customDelimiter = String.valueOf(input.charAt(2));
        return customDelimiter.equals(":") || customDelimiter.equals(",");
    }

    private boolean containsNonDelimiterCharacter(String input) {
        if (hasDelimiterDeclaration(input)) {
            String customDelimiter = String.valueOf(input.charAt(2));
            String calculationValue = input.substring(input.indexOf(SUFFIX.value()) + 2);
            return !calculationValue.matches("^[0-9,:"+ Pattern.quote(customDelimiter) + "]+$");
        }
        return !input.matches("^[0-9,:]+$");
    }
}
