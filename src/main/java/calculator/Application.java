package calculator;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Character.isDigit;

public class Application {

    private static String delimiters = "[,:]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 사용자 입력을 받는 메소드

        int RESULT = calculate(input);
        System.out.println("결과 : " + RESULT);

    }

    public static int calculate (String input){
        if(input.equals("")){ // 빈 값 처리해주기
            return 0;
        }
        return sum(input);
    }

    private static int sum (String numbers) {
        int SUM = 0;
        String[] splitedNumbers = numbers.split(delimiters);
        for (String number : splitedNumbers) {
                int NUM = Integer.parseInt(number);
            if (NUM < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + NUM);
            }
            SUM += NUM;
        }
        return SUM;
    }
}
