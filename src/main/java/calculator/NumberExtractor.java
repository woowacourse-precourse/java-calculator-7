package calculator;

// 문자열을 숫자로 분리하는 클래스
public class NumberExtractor {
    public String[] splitNumbers(String input, String delimiter) {
        return input.split(delimiter);
    }
}
