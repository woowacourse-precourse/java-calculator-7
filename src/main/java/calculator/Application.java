package calculator;

import calculator.controller.CalculatorController;
import calculator.dto.DelimiterInputDto;
import calculator.view.CalculatorRequest;
import calculator.view.CalculatorResponse;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CalculatorRequest calculatorRequest = new CalculatorRequest();
        CalculatorResponse calculatorResponse = new CalculatorResponse();
        CalculatorController calculatorController = new CalculatorController();

        calculatorRequest.getStartMessage();

        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(calculatorRequest.inputString(), new ArrayList<>(List.of(",", ":")));

        try {
            int result = calculatorController.calculateSum(delimiterInputDto);
            calculatorResponse.printResult(result);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
