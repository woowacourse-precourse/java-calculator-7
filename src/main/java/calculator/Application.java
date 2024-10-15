package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = 0;
        if(!("".equals(input))) {
            String[] splitNumbers = input.split(",|:");
            for (String number : splitNumbers) {
                result += Integer.parseInt(number);
            }
        }
        System.out.println("결과 : " + result);
    }
}
