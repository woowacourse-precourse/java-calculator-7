package calculator;

import java.util.ArrayList;
import java.util.List;

class Calculator {
    private String input;
    private final List<String> separators;
    private final List<Integer> numbers;
    private int result;

    public Calculator(String input) {
        this.input = input;
        this.result = 0;
        separators = new ArrayList<>();
        numbers = new ArrayList<>();
        separators.add(",");
        separators.add(":");
    }


    /***
     * 입력 받은 문자열의 커스텀 문자열이 있는지 확인
     */
    private void checkCustomSeparator() {
    }


    /***
     * 구분자를 기준으로 숫자를 추출한다.
     */
    private void extractNumbers() {
    }

    /***
     * 사용자로부터 문자열을 입력 받아 결과를 반환한다.
     * @return 정수 결과값
     */
    public int calculate() {
        return this.result;
    }
}
