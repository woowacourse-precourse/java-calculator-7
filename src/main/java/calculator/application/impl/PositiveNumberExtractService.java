package calculator.application.impl;

import calculator.application.ExtractService;
import calculator.utility.CharacterUtils;
import java.util.List;

public class PositiveNumberExtractService implements ExtractService {

    @Override
    public List<Long> extractNumbers(List<String> data) {
        return data.stream()
                .map(this::parseNumber)
                .toList();
    }

    private Long parseNumber(String data) {
        validateNumber(data);
        return Long.valueOf(data);
    }

    private void validateNumber(String data) {
        validateNotNullOrEmpty(data);
        validateOnlyDigits(data);
    }

    private void validateOnlyDigits(String data) {
        for (char word: data.toCharArray()) {
            if (CharacterUtils.isNotDigit(word)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNotNullOrEmpty(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
