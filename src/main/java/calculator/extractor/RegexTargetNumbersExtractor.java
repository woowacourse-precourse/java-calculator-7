package calculator.extractor;

import static calculator.constant.Constants.ErrorMessage.*;
import static calculator.constant.Constants.TargetNumber.*;

import calculator.domain.Separators;
import java.util.ArrayList;
import java.util.List;

public class RegexTargetNumbersExtractor implements TargetNumbersExtractor {

    @Override
    public List<Integer> run(Separators separators, String input) {
        String[] stringNumberArr = input.split(separators.data());
        return convertToTargetNumber(stringNumberArr);
    }

    private List<Integer> convertToTargetNumber(String[] StringNumberArr) {
        List<Integer> targetNumbers = new ArrayList<>();
        for (String stringNumber : StringNumberArr) {
            int number = convertToTargetNumber(stringNumber);
            targetNumbers.add(number);
        }
        return targetNumbers;
    }

    private int convertToTargetNumber(String value) {
        if (value.isBlank()) {
            return EMPTY_NUMBER;
        }

        try {
            int number = Integer.parseInt(value);
            checkTargetNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR, e);
        }
    }

    private void checkTargetNumberRange(int number) {
        if (number < NUMBER_MINIMUM_RANGE) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
    }

}
