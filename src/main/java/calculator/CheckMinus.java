package calculator;

public class CheckMinus {
    /**
     * 입력된 숫자가 음수인지 확인하는 메서드
     *
     * @param num 검사할 숫자
     * @throws IllegalArgumentException 입력된 숫자가 음수일 경우 발생합니다.
     */
    public void checkMinus(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
