package calculator.domain.calculator;

public class Validator {

    /**
     * 1. 커스텀 구분자가 오는 경우 //와 \n으로 감싸져야 한다. 2. 커스텀 구분자는 하나의 문자만 와야 한다.
     * 커스텀 구분자가 있으면 그것을, 없으면 빈 문자열 반환.
     */
    public String validateCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("//와 \\n 을 사용하여 커스텀 구분자를 지정해야 합니다.");
            }
            String customDelimiter = input.substring(2, endIndex);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다.");
            }
            return customDelimiter;
        }
        return "";
    }
}
