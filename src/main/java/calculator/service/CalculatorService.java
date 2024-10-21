package calculator.service;

import calculator.model.AddOperator;
import calculator.model.Operator;
import calculator.parser.Parser;

import java.util.List;

public class CalculatorService {

    private final Parser parser;
    private final Operator operator;

    public CalculatorService(){
        this.parser = new Parser();
        this.operator = new AddOperator();
    }

    /**
     * 입력된 문자열을 구분자를 기준으로 잘라주고 계산하는 메서드
     * @param input 입력된 문자열
     * @return 입력된 문자열의 계산 값
     */
    public int calculator(String input) {
        List<Integer> numberList = parser.parser(input);
        return operator.operate(numberList);
    }
}
