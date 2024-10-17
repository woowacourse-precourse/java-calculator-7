package calculator;

import java.util.Optional;

public class SeparatorExtractor {

    public ExtractResult extract(String expression) {
        String exp = expression;
        Character customSeparator = null;

        if (exp.startsWith("//")) {
            validateCustomSeparator(exp);

            customSeparator = exp.charAt(2);
            exp = exp.substring(5);
        }

        return new ExtractResult(exp, customSeparator);
    }

    private void validateCustomSeparator(String exp) {
        if (exp.length() >= 5 && exp.indexOf("\\n") == 3 && !isNumeric(exp.charAt(2))) {
            return;
        }
        throw new IllegalArgumentException("커스텀 구분자의 형식이 맞지 않습니다 : " + exp);
    }

    private boolean isNumeric(char c) {
        try {
            Double.parseDouble(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static class ExtractResult {
        private String expression;
        private Optional<Character> separator;

        private ExtractResult(String expression, Character separator) {
            this.expression = expression;
            this.separator = Optional.ofNullable(separator);
        }

        public String getExpression() {
            return expression;
        }

        public Optional<Character> getSeparator() {
            return separator;
        }
    }
}
