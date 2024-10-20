package calculator.facade;

import calculator.domain.Calculator;
import calculator.domain.Numbers;
import calculator.util.convertor.StringConvertor;
import calculator.util.parser.StringParser;
import calculator.util.validator.StringValidator;
import java.math.BigInteger;

public class CalculatorFacadeImpl implements CalculatorFacade {

    private final StringConvertor<Integer> stringConvertor;
    private final StringParser stringParser;
    private final StringValidator stringValidator;
    private final Calculator calculator;

    public CalculatorFacadeImpl(
            final StringConvertor<Integer> stringConvertor,
            final StringParser stringParser,
            final StringValidator stringValidator,
            final Calculator calculator
    ) {
        this.stringConvertor = stringConvertor;
        this.stringParser = stringParser;
        this.stringValidator = stringValidator;
        this.calculator = calculator;
    }

    @Override
    public BigInteger calculatorIntegerSum(final String str) {
        final Numbers<Integer> numbers = Numbers.ofInteger(str, stringConvertor, stringParser, stringValidator);
        return calculator.sumInteger(numbers);
    }
}
