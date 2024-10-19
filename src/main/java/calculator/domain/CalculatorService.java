package calculator.domain;

import calculator.domain.dto.InputRequest;
import calculator.domain.dto.OutputResponse;
import calculator.domain.modal.AddOperator;
import calculator.domain.modal.ArithmeticCalculator;
import calculator.domain.parser.CalculatorParser;
import java.util.List;

public class CalculatorService {
    private final ArithmeticCalculator arithmeticCalculator;

    public CalculatorService() {
        this.arithmeticCalculator = new ArithmeticCalculator(new AddOperator());
    }

    /**
     * 주어진 입력 요청을 기반으로 계산을 수행하고 결과를 반환합니다.
     *
     * @param request 입력 요청 객체, 계산할 문자열을 포함
     * @return 입력된 문자열에 대한 계산 결과를 담은 OutputResponse 객체
     */
    public OutputResponse calculate(InputRequest request) {
        List<Integer> integers = CalculatorParser.parseForDelimiters(request);
        return OutputResponse.of(arithmeticCalculator.calculate(integers));
    }

}
