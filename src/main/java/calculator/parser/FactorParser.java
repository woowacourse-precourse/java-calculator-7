package calculator.parser;

import calculator.exception.InputException;
import calculator.validator.FactorValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorParser {

    private FactorParser() {}

    public static List<Integer> parseFactors(String[] factors) {
        List<Integer> numbers = new ArrayList<>();

        Arrays.stream(factors)
                .filter(factor -> {
                    if(factor.isEmpty()) {
                        throw new InputException("잘못된 형식의 입력 값입니다.");
                    }
                    return true;
                })
                .forEach(factor -> numbers.add(FactorValidator.validateFactor(factor)));

        return numbers;
    }

}
