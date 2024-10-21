package calculator;

import calculator.dto.InputDTO;
import calculator.io.CalculatorIO;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputDTO input = CalculatorIO.getInput();
        CalculatorIO.loggingRes(0);
    }
}