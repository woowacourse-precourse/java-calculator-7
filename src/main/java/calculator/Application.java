package calculator;

import calculator.calculator.Calculator;
import calculator.input.InputReader;
import calculator.output.OutputViewer;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputViewer.printStartMessage();

        InputReader inputReader = new InputReader(Console.readLine());
        Calculator calculator = new Calculator(inputReader);

        int result = calculator.add();

        OutputViewer.printResultMessage(result);
    }
}
