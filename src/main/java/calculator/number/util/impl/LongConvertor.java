package calculator.number.util.impl;

import calculator.validator.constant.ErrorMessage;
import calculator.number.util.NumberConvertorService;
import java.util.List;

public class LongConvertor implements NumberConvertorService{
    @Override
    public Number stringToNumberBlankIsZero(String input) {
        try {
            if (input.isBlank()) return 0L;
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.MAX_VALUE_ERROR);
        }
    }

    @Override
    public List<Number> stringListToNumberList(List<String> numberInfo) {
        return numberInfo.stream()
                .map(this::stringToNumberBlankIsZero)
                .toList();
    }
}
