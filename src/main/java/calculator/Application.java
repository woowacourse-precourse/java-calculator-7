package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.view.CalculatorView;

import java.util.ArrayList;


import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Calculator calculator = new Calculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculator, view);

        controller.run();

    }
}

