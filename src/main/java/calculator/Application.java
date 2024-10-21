package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String input = getInput();

        System.out.print("결과 : " + calculator.getSum(input));
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        return Console.readLine();
    }
}
