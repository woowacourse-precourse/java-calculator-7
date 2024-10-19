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

    public int calculator(String input) {
        List<Integer> numberList = parser.parser(input);
        return operator.operate(numberList);
    }
}
