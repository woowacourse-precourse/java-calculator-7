package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import calculator.controller.CalculatorController;
import calculator.model.CalculationModel;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculationModel calculationModel = new CalculationModel();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController calculatorController = new CalculatorController(calculationModel,inputView,outputView);
        calculatorController.run();
    }
}