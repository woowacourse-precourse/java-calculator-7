package calculator;

import calculator.controller.CalculatorController;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        CalculatorController calculatorController = new CalculatorController();
        calculatorController.process();
    }
}