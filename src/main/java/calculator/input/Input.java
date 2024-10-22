package calculator.input;


import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static void printStartCalculatorMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static String getInputString() {
        return Console.readLine();
    }

}
