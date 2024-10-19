package calculator.model;

/**
 * 사용자로부터 입력받은 문자열 관리 model
 */
public class InputString {

    private String inputString;             // 문자열
    private long resultSum;                 // 문자열에서 추출한 숫자들을 더한 결과
    private String customDelimiter;         // 커스텀 구분자

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    //== 비즈니스 로직 ==//

    /**
     * 문자열에서 숫자를 추출해서 덧셈한다.
     *
     * @return resultSum 덧셈 계산 결과값
     */
    public long calculate() {
        getCustomDelimiter();

        String delimiters = this.customDelimiter == null ? ",|:" : customDelimiter + "|,|:";

        return this.resultSum;
    }

    /**
     * 문자열에서 커스텀 구분자 추출
     */
    private void getCustomDelimiter() {
        if (inputString.startsWith("//") && inputString.substring(3, 5).equals("\\n")) {
            this.customDelimiter = inputString.substring(2, 3);
            this.inputString = inputString.substring(5);
        }
    }

}
