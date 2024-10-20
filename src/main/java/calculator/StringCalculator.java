package calculator;

public class StringCalculator {
    // 문자가 없거나 빈 문자열이 입력되었을 때 0을 반환
    static int calc(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        } else {
            return getSplit(text);
        }
    }
}
