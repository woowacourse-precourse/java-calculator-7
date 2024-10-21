package calculator;

import static calculator.Delimiter.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class InputPreprocessing {
    private static final BigDecimal EMPTY_VALUE = BigDecimal.valueOf(0);
    private final Delimiter delimiter;

    public InputPreprocessing(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public List<BigDecimal> of(String input) {
        input = preprocessInput(input);
        return Arrays.stream(input.split(delimiter.get()))
                .map(this::processElement)
                .toList();
    }

    private String preprocessInput(String input) {
        if (delimiter.isCustomDelimiter()) {
            return input.substring(CUSTOM_DELIMITER_PREFIX_SIZE + CUSTOM_DELIMITER_SUFFIX_SIZE + delimiter.size());
        }
        return input;
    }

    private BigDecimal processElement(String element) {
        validateSplit(element);
        return castingElementToBigDecimal(element);
    }

    private void validateSplit(String input) {
        if (!input.matches("\\d+(\\.\\d+)?") && !input.isEmpty() && !input.matches("")) {
            throw new IllegalArgumentException("구분자 외의 문자나 음수가 존재합니다.");
        }
    }

    private BigDecimal castingElementToBigDecimal(String element) {
        if (!element.isEmpty()) {
            BigDecimal number = new BigDecimal(element);
            validatePositive(number);
            return number;
        }
        return EMPTY_VALUE;
    }


    private void validatePositive(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("더하는 값은 양수만 가능합니다.");
        }
    }
}
