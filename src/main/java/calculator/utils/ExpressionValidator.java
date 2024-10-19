package calculator.utils;

public class ExpressionValidator {

    private static final String REGULAR_EXPRESSION = "^(//.\\n)?([0-9]*([0-9]+.?)*)?";
    private static final String BLANK = "";
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";
    private static final String CUSTOM_SEPARATOR_FORMAT = "//.\\n";

    private String expression;
    private String separators;

    public ExpressionValidator(String expression, String separators) {
        this.expression = expression;
        this.separators = separators;
        if (hasCustomSeparator()) {
            String customSeparator = String.valueOf(expression.charAt(2)); // 커스텀 구분자
            if (Character.isDigit(customSeparator.charAt(0))) { // 커스텀 구분자로 숫자가 전달된 경우
                throw new IllegalArgumentException();
            }
            this.separators += customSeparator;
            this.expression = expression.replace(CUSTOM_PREFIX + customSeparator + CUSTOM_SUFFIX, BLANK);
        }
    }

    public String getSeparators() {
        return separators;
    }
    public String getExpression() {
        return expression;
    }

    public boolean isValid() {
        if (expression.isEmpty()) {
            return true;
        }
        if (!isValidFormat()) {
            return false;
        }
        for (char ch : expression.toCharArray()) {
            if (!isValidComponent(ch)) { // 숫자도 아니고 등록된 구분자도 아닌 경우
                return false;
            }
        }
        return true;
    }

    private boolean hasCustomSeparator() {
        if (expression.isEmpty()) {
            return false;
        }
        if (expression.length() >= CUSTOM_SEPARATOR_FORMAT.length()) {
            return expression.startsWith(CUSTOM_PREFIX) && expression.startsWith(CUSTOM_SUFFIX, CUSTOM_PREFIX.length() + 1);
        }
        return false;
    }

    private boolean isValidComponent(char ch) {
        return Character.isDigit(ch) || separators.contains(String.valueOf(ch));
    }

    private boolean isValidFormat() {
        return isMatchRegularExpression() && isValidLastChar();
    }
    
    private boolean isMatchRegularExpression() {
        return expression.matches(REGULAR_EXPRESSION);
    }

    private boolean isValidLastChar() {
        char lastChar = expression.charAt(expression.length() - 1);
        return Character.isDigit(lastChar);
    }
}
