package calculator.model;

public class Expression {
    private final String expression;

    public Expression(String expression) {
        // 로직 들어갈 예정
        this.expression = encoding(expression);
    }

    public String getExpression() {
        return expression;
    }

    /**
     *
     * @param expression 검증된 input
     * @return           정제된 계산식
     * 사실 덧셈 계산기면 없어도 되는 로직이기도 함
     */
    private String encoding(String expression) {
        final String pattern = "^\\d.*";

        // 커스텀 구분자가 있는 경우 문자열을 분리
        if (!expression.matches(pattern)) {
            final String splitPattern = "(?<=\\D)(?=\\d)";

            String[] parts = expression.split(splitPattern,2);
            expression = parts[1];
            // 계산식 부분
        }

        char[] charArray = expression.toCharArray();
        StringBuilder encodedExpression = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            encodeDelimiter(charArray[i],i,encodedExpression);
        }

        return encodedExpression.toString();
    }

    private void encodeDelimiter(char delimiter, int index, StringBuilder str) {
        if (index%2 != 0) {
            str.append("+");
            return;
        }
        str.append(delimiter);
    }
}
