package calculator;

import java.util.ArrayList;
import java.util.List;

class Calculator {
    private String input;
    private final List<String> separators;
    private final List<Integer> numbers;
    private int result;

    final static int CUSTOM_SEPARATOR_INDEX = 2;
    final static int CUSTOM_SEPARATOR_END_INDEX = 5;

    public Calculator(String input) {
        this.input = input;
        this.result = 0;
        separators = new ArrayList<>();
        numbers = new ArrayList<>();
        separators.add(",");
        separators.add(":");
    }


    /***
     * 입력 받은 문자열에 커스텀 문자가 있다면 추출한다.
     */
    private void checkCustomSeparator() {
        // 커스텀 문자열이 있는지 확인
        if (input.startsWith("//")) {
            if (!input.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            separators.add(input.charAt(CUSTOM_SEPARATOR_INDEX) + "");
            this.input = input.substring(CUSTOM_SEPARATOR_END_INDEX);
        }
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
        checkCustomSeparator();
        // TODO: 입력값이 숫자와 구분자로만 이루어졌는지 확인
        return this.result;
    }
}
