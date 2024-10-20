package calculator.validator;

import calculator.utils.CalculatorRegex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorValidator {

    public void validateExpression(String expression) {

        // 입력값이 없거나 null인 경우 예외 처리
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        // 커스텀 구분자가 존재하는 경우
        if (expression.startsWith("//")) {
            Matcher matcher = Pattern.compile(CalculatorRegex.CUSTOM_SEPERATOR_REGEX).matcher(expression);
            if (!matcher.find()) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
        }
    }

    public void validatePositiveNumber(String number) {

        if (number.contains("-")) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        if (!number.matches(CalculatorRegex.POSITIVE_NUMBER_REGX)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
