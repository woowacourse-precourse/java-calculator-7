package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {

        Input.readLine();

        Calculator calculator = new Calculator();
        int result = calculator.calculateSum(Input.getInput());

        Output.outLine(result);

    }
}
