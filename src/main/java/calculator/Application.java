package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(input.isEmpty()){
            throw new IllegalArgumentException("올바르지 않은 입력값입니다. 프로그램을 종료합니다.");
        }

    }
}
