package calculator;

import calculator.domain.CalculatorService;
import calculator.infrastructure.AddCalculator;
import calculator.infrastructure.InputParser;
import calculator.infrastructure.SplitStrValidator;
import calculator.interfaces.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        AddCalculator addCalculator = new AddCalculator();
        SplitStrValidator splitStrValidator = new SplitStrValidator();

        CalculatorService calculatorService = new CalculatorService(inputParser, splitStrValidator,
                addCalculator);

        CalculatorController calculatorController = new CalculatorController(calculatorService);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInputStr = Console.readLine();
        try {
            System.out.println("결과 : " + calculatorController.startCalculator(userInputStr));
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
