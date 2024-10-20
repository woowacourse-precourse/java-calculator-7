package calculator.model;

/**
 * 사용자로부터 입력받은 문자열 관리 model
 */
public class InputString {

    public static final int CUSTOM_DELIMITER_RANGE = 3;

    private String inputString;             // 문자열
    private long[] numberList;              // 문자열에 포함된 숫자 리스트

    public InputString(String input) {
        this.inputString = input;
    }

    //== 비즈니스 로직 ==//

    /**
     * 문자열에서 커스텀 구분자 추출
     */
    public String getCustomDelimiterFromInput() {
        if (inputString.startsWith("//") && inputString.startsWith("\\n", CUSTOM_DELIMITER_RANGE)) {
            String customDelimiter = inputString.substring(2, CUSTOM_DELIMITER_RANGE);
            this.inputString = inputString.substring(5);
            return customDelimiter;
        }
        return null;
    }

    /**
     * 문자열 검증 (숫자, 구분자 외의 다른 값은 입력할 수 없다.)
     */
    public String validateInputString(String delimiters) {

        String invalidCharsRegex = "[^[0-9]" + delimiters + "]";

        if (inputString.matches(".*" + invalidCharsRegex + ".*")) {
            throw new IllegalArgumentException("입력은 양수와 구분자만을 포함해야 합니다.");
        }

        return this.inputString;
    }

    /**
     * 문자열로부터 추출된 숫자 리스트 저장
     */
    public long[] saveNumberList(long[] numberList) {
        this.numberList = numberList;
        return this.numberList;
    }

}
