package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator.printStart();
        Calculator calculator = new Calculator(Console.readLine());
        calculator.run();
    }
}
