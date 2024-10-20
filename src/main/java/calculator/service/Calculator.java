package calculator.service;

import calculator.domain.Numbers;
import calculator.dto.Query;
import calculator.service.parser.NumbersParser;
import calculator.service.parser.QueryParser;

public class Calculator {
    private final QueryParser queryParser;
    private final NumbersParser numbersParser;


    public Calculator(QueryParser queryParser, NumbersParser numbersParser) {
        this.queryParser = queryParser;
        this.numbersParser = numbersParser;
    }

    public int calculate(String input) {
        Query query = queryParser.parser(input);
        Numbers numbers = numbersParser.parser(query);
        return numbers.sum();
    }
}
