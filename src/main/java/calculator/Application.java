package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 문자열을 입력 받아 저장한다.
        String inputStr = Console.readLine();
        Console.close();
        Calculator calculator = new Calculator(inputStr);
    }
}
