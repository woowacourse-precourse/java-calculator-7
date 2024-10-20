package calculator.util;

public class extractNumbersPart {
    // 커스텀 구분자 이후 숫자파트 추출하는 메서드
    public static String extractNumbersPart(String input) {
        int index = input.lastIndexOf("\n");
        if (index != -1) {
            return input.substring(index + 1).trim();
        }
        return input;
    }
}
