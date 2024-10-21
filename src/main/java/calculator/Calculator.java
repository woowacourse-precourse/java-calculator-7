package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void run() {
        String inputValue = input();
        System.out.println(inputValue);
    }

}
