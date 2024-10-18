package calculator;

import camp.nextstep.edu.missionutils.Console;

public class    Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String string = Console.readLine();

        Calculator calculator = new Calculator();
        int result=0;
        result=calculator.add(string);

        System.out.println("결과: "+ result);
    }
}
