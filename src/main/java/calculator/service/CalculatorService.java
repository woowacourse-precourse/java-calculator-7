package calculator.service;

import calculator.model.CalculatorLogic;
import java.util.Scanner;

public class CalculatorService {
    private final CalculatorLogic calculatorLogic = new CalculatorLogic();

    public int calculate(String input) {
        Scanner sc = new Scanner(input);
        try {
            //validation에서 input에 대한 검증 코드 추가 - validation이 에러 throw 하면 하위 코드 실행 없이 controller로 에러 throw
            String delimiter = calculatorLogic.extractDelimiter(sc.nextLine());

            if (sc.hasNext()) {
                return calculatorLogic.calculate(calculatorLogic.extractNumbers(sc.nextLine(), delimiter));
            }
            return calculatorLogic.calculate(calculatorLogic.extractNumbers(input, delimiter));

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
