package calculator;

import calculator.calculator.Calculator;
import calculator.calculator.Parser;
import calculator.output.OutputViewer;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputViewer.printStartMessage();

        Calculator calculator = new Calculator(new Parser());
        int result = calculator.add(Console.readLine());

        OutputViewer.printResultMessage(result);
    }
}
