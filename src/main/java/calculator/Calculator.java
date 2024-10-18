package calculator;

import calculator.delimiter.filter.ValidationFilter;
import calculator.delimiter.handler.DelimiterHandler;
import calculator.delimiter.handler.factory.DelimiterHandlerFactory;

public class Calculator {
    private final DelimiterHandlerFactory factory;
    private final ValidationFilter filter;

    public Calculator(DelimiterHandlerFactory factory, ValidationFilter filter) {
        this.factory = factory;
        this.filter = filter;
    }

    public Integer sum(String str) {
        filter.validate(str);
        DelimiterHandler handler = factory.getHandler(str);

        return handler.split(str)
                .parallelStream().mapToInt(Integer::parseInt)
                .sum();
    }
}
