package calculator.model;

public class Separator {
    public String raw = ",:"; // 기본 구분자

    // 구분자 문자열에 커스텀 구분자를 추가하는 메소드
    private void append(String customSeparator) {
        raw += customSeparator;
    }

    // 커스텀 구분자 문자열을 분리하고 수식을 반환하는 메소드
    public String consumeCustomSeparator(String expression) {
        if(hasCustomSeparator(expression)) {
            int newlineIndex = expression.indexOf("\n");
            String customSeparator = expression.substring(2, newlineIndex); // //와 \n 사이의 문자열을 추출
            append(customSeparator); // 커스텀 구분자인 추출한 문자열을 구분자에 추가

            return expression.substring(newlineIndex + 1); // 커스텀 구분자를 제외한 수식 부분을 반환
        }

        return expression; // 커스텀 구분자가 없으니 수식을 그대로 반환
    }

    // 커스텀 구분자가 있는지 검사하는 메소드
    private boolean hasCustomSeparator(String expression) {
        boolean startsWithDoubleSlash = expression.startsWith("//");
        boolean containsNewline = expression.contains("\n");

        return startsWithDoubleSlash && containsNewline;
    }
}
