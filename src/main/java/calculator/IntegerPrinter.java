package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class IntegerPrinter {

    public IntegerPrinter() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String userInput = readLine();
        Calculator calculator = new Calculator(userInput);
        calculator.printResult();
    }

}
