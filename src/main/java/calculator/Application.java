package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 문자열 입력 받기
        String input = Console.readLine();
        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            int result = StringCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 잘못된 문자열 입력 시 오류 메시지 출력
            System.out.println(e.getMessage());
        }
    }
}

class StringCalculator{
    public static int add(String input){
        // 빈 문자열 또는 null 입력 시 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 1;
        return sum;
    }
}
