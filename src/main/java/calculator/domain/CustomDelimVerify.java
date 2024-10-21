package calculator.domain;

import calculator.domain.constant.CustomDelimBracket;
import calculator.domain.constant.Unit;

public class CustomDelimVerify {

    public static Boolean exist(String candidate) {
        return suitableLength(candidate) && coveredBracket(candidate);
    }

    private static Boolean suitableLength(String candidate) {
        return candidate.length() >= Unit.CUSTOM_DELIM_EXPRESSION_LENGTH.getValue();
    }

    public static Boolean coveredBracket(String candidate) {
        return correctOpenBracket(candidate)
                && CorrectCloseBracket(candidate);
    }

    private static boolean correctOpenBracket(String candidate) {
        return candidate.startsWith(CustomDelimBracket.OPEN.get());
    }

    private static boolean CorrectCloseBracket(String candidate) {
        return candidate.endsWith(CustomDelimBracket.CLOSE.get());
    }
}
