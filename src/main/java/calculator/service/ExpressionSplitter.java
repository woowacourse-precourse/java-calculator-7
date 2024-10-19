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
            throw new IllegalArgumentException("식이 존재하지 않습니다.");
        }
        if (hasUnrecognizedSeparator(possibleSeparatorsRegex, expression)) {
            throw new IllegalArgumentException("식별되지 않는 구분자가 포함되어 있습니다.");
        }
    }

    private static boolean hasUnrecognizedSeparator(String possibleSeparatorsRegex, String expression) {
        return !expression.matches("[" + possibleSeparatorsRegex + Constants.POSITIVE_NUMBER_REGEX + "]+");
    }
}
