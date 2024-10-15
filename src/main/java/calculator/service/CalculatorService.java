package calculator.service;

import calculator.model.CalculatorLogic;

public class CalculatorService {
    private final CalculatorLogic calculatorLogic = new CalculatorLogic();

    public int calculate(String input) {
        try {
            //validation에서 input에 대한 검증 코드 추가 - validation이 에러 throw 하면 하위 코드 실행 없이 controller로 에러 throw
            String delimiter = calculatorLogic.extractDelimiter(input);
            return calculatorLogic.calculate(calculatorLogic.extractNumbers(input, delimiter));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
