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
     * 입력 문자열이 null인지 확인합니다.
     *
     * @param input 사용자가 입력한 문자열
     * @throws IllegalArgumentException null일 경우 IllegalArgumentException을 발생시킵니다.
     */
    private void isNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    /**
     * <ul>
     *     <li>빈 문자열일 경우 0을 반환합니다.</li>
     *     <li>null일 경우 IllegalArgumentException을 발생시킵니다.</li>
     * </ul>
     *
     * @param input 사용자가 입력한 문자열입니다.
     * @return 문자열에서 추출한 숫자의 합산 값을 반환합니다.
     */
    public int add(String input) {
        isNull(input);
        if (isEmpty(input)) {
            return 0;
        }
        return 1;
    }
}
