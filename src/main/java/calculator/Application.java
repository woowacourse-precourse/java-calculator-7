package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController controller = new CalculatorController(new InputView(new Scanner(System.in)), new OutputView(), new StringCalculator());
        controller.applicationRun();
    }
}
