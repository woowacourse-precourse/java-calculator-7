package calculator.service;

import calculator.util.Constants;

import java.util.List;

public class ExpressionSplitter {

    public static String[] split(Separators separators, String expression) {
        List<String> possibleSeparators = separators.getValues();
        String possibleSeparatorsRegex = String.join(Constants.OR, possibleSeparators);
        return expression.split(possibleSeparatorsRegex);
    }
}
