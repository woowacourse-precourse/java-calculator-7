package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.DelimiterInputDto;
import calculator.view.CalculatorRequest;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CalculatorRequest calculatorRequest = new CalculatorRequest();
        CalculatorController calculatorController = new CalculatorController();

        calculatorRequest.getStartMessage();

        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(calculatorRequest.inputString(), new ArrayList<>(List.of(",", ":")));

        calculatorController.calculateSum(delimiterInputDto);
    }
}
