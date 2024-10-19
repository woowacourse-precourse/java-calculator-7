package calculator;

import camp.nextstep.edu.missionutils.Console;

import calculator.StringUtil.*;


public class Application {

    public static void main(String[] args) {
        String input;
        char customDelimiter;
        int[] numbers = {};

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
        // 간단한 입력 예외 확인
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        }
        else if (input.length() == 1 && StringUtil.isDigit((input.charAt(0)))) {
            System.out.println("결과 : " + input);
        }

        if (StringUtil.hasCustomDelimiter(input)) {
            customDelimiter = StringUtil.getCustomDelimiter(input);
        }


    }
}
