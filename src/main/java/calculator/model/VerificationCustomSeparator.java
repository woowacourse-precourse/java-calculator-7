package calculator.model;

public class VerificationCustomSeparator {

    public static void verifyCustomSeparator(String custom) {
        verifyCustomIncludeNums(custom);
        verifyCustomGrammar(custom);
    }

    private static void verifyCustomIncludeNums(String custom) {
        if (custom.matches("[+-]?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("커스텀 구분자에는 숫자가 들어갈 수 없습니다!");
        }
    }

    private static void verifyCustomGrammar(String custom) {
        if (custom.contains("//") || custom.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자에는 //과 \\n이 들어갈 수 없습니다!");
        }
    }
}
