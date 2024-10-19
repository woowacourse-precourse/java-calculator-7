package calculator.service;

import calculator.util.Constants;
import java.util.List;

public class ExpressionSplitter {

    public static String[] split(Separators separators, String expression) {
        List<String> recognizedSeparators = separators.getValues();
        String recognizedSeparatorsRegex = String.join(Constants.OR, recognizedSeparators);
        validateExpression(recognizedSeparatorsRegex, expression);
        return expression.split(recognizedSeparatorsRegex);
    }

    private static void validateExpression(String possibleSeparatorsRegex, String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("계산할 식을 찾을 수 없어요. 입력값을 확인해주세요.");
        }
        if (hasUnrecognizedSeparator(possibleSeparatorsRegex, expression)) {
            throw new IllegalArgumentException("숫자와 사용 가능한 구분자 외에 다른 문자가 포함되어 있습니다. 입력값을 확인해주세요.");
        }
    }

    private static boolean hasUnrecognizedSeparator(String possibleSeparatorsRegex, String expression) {
        return !expression.matches("[" + possibleSeparatorsRegex + Constants.POSITIVE_NUMBER_REGEX + "]+");
    }
}
