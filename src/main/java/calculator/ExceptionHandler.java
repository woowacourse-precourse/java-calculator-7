package calculator;

public class ExceptionHandler {
    // 문자열에 음수가 포함된 경우 IllegalArgumentException 발생
    public void checkForNegativeNumbers(char c, int i, String input) {
        // 음수 기호 '-'를 확인하고, 다음 문자가 숫자인 경우 음수로 처리
        if (c == '-' && i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
            throw new IllegalArgumentException("음수가 포함된 입력: " + input);
        }
    }
}
