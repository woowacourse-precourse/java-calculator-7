package calculator.domain;

/**
 * 프로그램의 입력값인 문자열을 정의한 클래스
 */
public class InputtedString {

    private final String line;

    public InputtedString(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
