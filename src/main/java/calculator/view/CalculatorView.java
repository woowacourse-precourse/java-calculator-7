package calculator.view;

import static calculator.util.ConstantVariable.PROGRAM_START;
import static calculator.util.PrintStringUtils.printString;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculateRequest;
import calculator.util.SingletonObjectProvider;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private final CalculatorController calculatorController;

    public CalculatorView() {
        this.calculatorController = SingletonObjectProvider.getSingletonObject(CalculatorController.class);
    }

    public void startCalculateProgram() {
        printString(PROGRAM_START.value());
        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        calculatorController.calculate(CalculateRequest.from(input));
    }
}
