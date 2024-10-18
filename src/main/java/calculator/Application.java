package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        try (Calculator calculator = new Calculator()) {
            calculator.displayPrompt();
            calculator.readInput(Console.readLine());
            calculator.printSum();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
