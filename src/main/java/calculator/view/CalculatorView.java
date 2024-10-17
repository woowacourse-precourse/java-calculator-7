package calculator.view;

import static calculator.util.ConstantVariable.PROGRAM_START;
import static calculator.util.CustomStringUtils.printStringLineFeed;

import calculator.controller.CalculatorController;
import calculator.dto.request.CalculateRequest;
import calculator.dto.response.CalculateResultResponse;
import calculator.util.SingletonObjectProvider;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private final CalculatorController calculatorController;

    public CalculatorView() {
        this.calculatorController = SingletonObjectProvider.getSingletonObject(CalculatorController.class);
    }

    public void startCalculateProgram() {
        printStringLineFeed(PROGRAM_START.value());
        String input = Console.readLine();

        if (input == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        CalculateResultResponse response = calculatorController.calculate(CalculateRequest.from(input));

        printStringLineFeed(String.valueOf(response.result()));
    }
}
