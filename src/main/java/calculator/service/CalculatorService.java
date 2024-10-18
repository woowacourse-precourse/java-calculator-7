package calculator.service;

import calculator.model.Delimiters;
import calculator.model.Numbers;
import calculator.util.ExtractionUtil;
import calculator.util.InputValidator;
import java.math.BigDecimal;
import java.util.List;

public class CalculatorService {

    public String calculate(String rawInput) {
        Delimiters delimiters = Delimiters.from(rawInput);
        String expression = ExtractionUtil.extractExpression(rawInput);
        InputValidator.validateExpression(expression, delimiters.getDelimiters());
        List<BigDecimal> numbers = Numbers
                .of(expression, delimiters)
                .getNumbers();
        // todo : Calculator를 이용하여 계산 진행
        return ""; // todo : 연산 결과 반환
    }
}
