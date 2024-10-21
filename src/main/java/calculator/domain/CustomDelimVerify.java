package calculator.domain;

import calculator.domain.constant.CustomDelimBracket;

public class CustomDelimVerify {

    private static Boolean suitableLength(String candidate) {
        return candidate.length() >= 5;
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
