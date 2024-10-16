package calculator.domain.calculator;

public class Validator {

    /**
     * 1. 커스텀 구분자가 오는 경우 //와 \n으로 감싸져야 한다.
     * 2. 커스텀 구분자는 하나의 문자만 와야 한다.
     * 3. 커스텀 구분자가 있으면 그것을, 없으면 빈 문자열을 반환한다.
     */
    public String extractCustomDelimiter(String input) {
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

    /**
     * 커스텀 문자가 오는 경우, 이후의 숫자 부분들만 추출한다.
     *
     * @param input
     * @return
     */
    public String extractNumbersPart(String input) {
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {
                throw new IllegalArgumentException("//와 \\n 을 사용하여 커스텀 구분자를 지정해야 합니다.");
            }

            return input.substring(endIndex + 2);
        }
        return input;
    }

    public void validatePositiveNumber(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 1) {
                throw new IllegalArgumentException("양수만 입력 가능합니다: " + value);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }
}
