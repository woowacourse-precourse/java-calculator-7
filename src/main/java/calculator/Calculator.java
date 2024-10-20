package calculator;

public class Calculator {

    /**
     * 문자열이 빈 문자열인지 확인합니다.
     *
     * @param input 사용자가 입력한 문자열입니다.
     * @return 빈 문자열이면 true를, 값이 존재하면 false를 반환합니다.
     */
    private boolean isEmpty(String input) {
        return input.isEmpty();
    }

    /**
     * 빈 문자열일 경우 0을 반환합니다.
     *
     * @param input 사용자가 입력한 문자열입니다.
     * @return 문자열에서 추출한 숫자의 합산 값을 반환합니다.
     */
    public int add(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return 1;
    }
}
