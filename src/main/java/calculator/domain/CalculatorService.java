package calculator.domain;

import calculator.domain.modal.AddOperator;
import calculator.domain.modal.ArithmeticCalculator;
import calculator.domain.parser.CalculatorParser;
import java.util.List;

public class CalculatorService {
    private final CalculatorParser calculatorParser;
    private final ArithmeticCalculator arithmeticCalculator;

    public CalculatorService() {
        this.calculatorParser = new CalculatorParser();
        this.arithmeticCalculator = new ArithmeticCalculator(new AddOperator());
    }

    /**
     * 주어진 입력 문자열을 계산하여 결과를 반환합니다.
     *
     * @param input 계산할 문자열 입력
     * @return 주어진 입력에 대한 계산 결과
     */
    public int calculate(String input) {
        List<Integer> parse = calculatorParser.parse(input);
        return arithmeticCalculator.calculate(parse);
    }
}
