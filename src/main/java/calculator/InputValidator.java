package calculator;

public class InputValidator {
    public void validateCustomDelimiterFormat(int startIndex, int endIndex) {
        if(startIndex != endIndex) {
            throw new IllegalArgumentException("커스텀 구분자는 //문자\\n 형식이어야 합니다.");
        }
    }
}
