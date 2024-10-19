package calculator.number.util.impl;

import calculator.number.util.NumberConvertorService;

import java.util.List;

public class DoubleConvertor implements NumberConvertorService{
    @Override
    public Number stringToNumberBlankIsZero(String input) {
        if (input.isBlank()) return 0.0;
        return Double.parseDouble(input);
    }

    @Override
    public List<Number> stringListToNumberList(List<String> numberInfo) {
        return numberInfo.stream()
                .map(this::stringToNumberBlankIsZero)
                .toList();
    }
}
