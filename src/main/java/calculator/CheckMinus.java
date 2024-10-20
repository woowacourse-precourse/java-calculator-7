package calculator;

public class CheckMinus {
    // 음수 체크
    public void checkMinus(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
