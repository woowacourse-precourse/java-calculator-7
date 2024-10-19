package calculator.model;

/**
 * 사용자로부터 입력받은 문자열 관리 model
 */
public class InputString {

    private String inputString;             // 문자열
    private long resultSum;                 // 문자열에서 추출한 숫자들을 더한 결과
    private Character[] customSeparator;    // 커스텀 구분자

    public InputString(String inputString) {
        this.inputString = inputString;
    }

}
