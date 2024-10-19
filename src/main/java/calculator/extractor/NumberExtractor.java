package calculator.extractor;

import static calculator.constants.Constants.ERROR_MESSAGE;
import static calculator.constants.Constants.MAXIMUM_NUMBER;

import calculator.data.CalculationData;
import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {
    public static List<Long> extractValues(CalculationData calculationData) {
        String valueString = calculationData.getValueString();
        String delimiterPattern = calculationData.getDelimiterPattern();
        // 계산해야 할 값들 리스트에 담아 리턴
        return makeValueList(valueString, delimiterPattern);
    }

    private static List<Long> makeValueList(String valueString, String delimiterPattern) {
        List<Long> values = new ArrayList<>();

        String[] stringValues = valueString.split(delimiterPattern);
        for (String stringValue : stringValues) {
            long longValue = getLongValue(stringValue);
            validateLongValue(longValue);
            values.add(longValue);
        }
        return values;
    }

    private static long getLongValue(String stringValue) {
        long longValue;
        try {
            longValue = Long.parseLong(stringValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return longValue;
    }

    private static void validateLongValue(long longValue) {
        if (longValue > MAXIMUM_NUMBER)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        if (longValue < 0)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
