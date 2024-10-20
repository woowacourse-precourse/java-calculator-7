package calculator;

import calculator.delimiter.handler.DelimiterHandler;
import calculator.delimiter.handler.factory.DelimiterHandlerFactory;
import java.math.BigInteger;

public class Calculator {
    private final DelimiterHandlerFactory factory;

    public Calculator(DelimiterHandlerFactory factory) {
        this.factory = factory;
    }

    public BigInteger sum(String str) {
        DelimiterHandler handler = factory.getHandler(str);

        return handler.split(str).parallelStream()
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
