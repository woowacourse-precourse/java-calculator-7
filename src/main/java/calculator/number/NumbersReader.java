package calculator.number;

import calculator.command.NumbersLine;
import calculator.delimiter.Delimiter;
import calculator.number.rule.NumbersRule;

import java.util.Arrays;

public class NumbersReader {
    public NumbersReader(NumbersRule validator) {
        this.validator = validator;
    }

    private final NumbersRule validator;

    public int[] readNumbers(NumbersLine numbersLine, Delimiter delimiter) {
        if(numbersLine.isEmpty())
            return new int[]{0};

        int[] result = toIntegerArray(delimiter.split(numbersLine));
        if(validator.isInvalid(result))
            throw new IllegalArgumentException("");
        return result;
    }

    private int[] toIntegerArray(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .mapToInt(Integer::valueOf)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자", e);
        }
    }
}
