package calculator;

public class StringValueDivide {

    private static String customDelimiterAssign;
    private static String expression;

    public static void divide(String stringValue) {
        int divideIndex = stringValue.lastIndexOf("\\n");

        if (divideIndex == -1) {
            // 커스텀 구분자 없음
            customDelimiterAssign = "";
            expression = stringValue;
            return;
        }

        // 마지막 "\n" 기준으로 나누기
        customDelimiterAssign = stringValue.substring(0, divideIndex + 2);
        expression = stringValue.substring(divideIndex + 2);
    }

    public static String getCustomDelimiterAssign() {
        return customDelimiterAssign;
    }

    public static String getExpression() {
        return expression;
    }
}