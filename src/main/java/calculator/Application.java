package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int sum;
        if (input.isEmpty() || input.trim().isEmpty()){
            sum = 0;
            System.out.println("결과 : " + sum);
        } else {
            System.out.println("공백이 아닙니다.");
        }//if end
    }
}
