package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    // 입력값이 없는 경우 리턴 되는 값
    private static final int EMPTY_RESULT = 0;
    // 입력값이 1자리인 경우를 체크하기 위한 값
    private static final int SINGLE_DIGIT_LENGTH = 1;

    // intSum, parseInt 메서드를 사용하기 위한 Utils 객체 생성
    CalculatorUtils calculatorUtils = new CalculatorUtils();

    public int calculate(String input) {
        // 입력값이 없는 경우에 대한 예외 처리
        if (input.isEmpty()) {
            return EMPTY_RESULT;
        }

        // 입력값이 1자리인 경우 그 숫자 그대로 반환
        if (input.length() == SINGLE_DIGIT_LENGTH) {
            return calculatorUtils.parseInt(input);
        }

        // 구분자 생성
        String separator = new CustomSeparator().separator(input);

        // 커스텀 구분자가 있을 경우 \n 이후의 문자열부터 슬라이싱
        if (input.startsWith("/")) {
            input = input.substring(input.indexOf("n") + 1);
        }

        // 구분자를 사용해 각 문자를 슬라이싱한다.
        String[] inputArr = input.split(separator);

        // 더해진 값 리턴
        return calculatorUtils.intSum(inputArr);
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int value = calculate(input);
        System.out.println("결과 : " + value);
    }
}
