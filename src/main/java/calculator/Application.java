package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        Input.readLine();

        Calculator calculator = new Calculator();
        Output.outLine(calculator.calculateSum(Input.getInput()));

    }
}
