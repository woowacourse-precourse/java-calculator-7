package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.displayPrompt();
            calculator.readInput(Console.readLine());
            calculator.printSum();
        } finally {
            Console.close();
        }
    }
}
