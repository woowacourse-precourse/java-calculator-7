package calculator.util.number;

import calculator.common.exception.ExceptionFactory;
import calculator.util.number.integer.IntegerUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static calculator.common.exception.ExceptionType.UNSUPPORTED_NUMBER_CLASS;

public class NumberUtils {

    private static final Map<Class<? extends Number>, Function<List<? extends Number>, Number>> SUM_FUNCTIONS = new HashMap<>();
    private static final Map<Class<? extends Number>, Function<List<String>, List<? extends Number>>> PARSE_FUNCTIONS = new HashMap<>();

    static {
        SUM_FUNCTIONS.put(Integer.class, numbers -> IntegerUtils.sum(numbers.stream().map(Number::intValue).toList()));

        PARSE_FUNCTIONS.put(Integer.class, IntegerUtils::parseIntegers);
    }

    public static Number sum(List<? extends Number> numbers, Class<? extends Number> numberClass) {
        Function<List<? extends Number>, Number> sumFunction = SUM_FUNCTIONS.get(numberClass);
        if (sumFunction != null) {
            return sumFunction.apply(numbers);
        }
        throw ExceptionFactory.createException(UNSUPPORTED_NUMBER_CLASS);
    }

    public static List<? extends Number> parseNumbers(List<String> values, Class<? extends Number> numberClass) {
        Function<List<String>, List<? extends Number>> parseFunction = PARSE_FUNCTIONS.get(numberClass);
        if (parseFunction != null) {
            return parseFunction.apply(values);
        }
        throw ExceptionFactory.createException(UNSUPPORTED_NUMBER_CLASS);
    }
}
