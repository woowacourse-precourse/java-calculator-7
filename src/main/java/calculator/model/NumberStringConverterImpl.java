package calculator.model;

import calculator.view.Message;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberStringConverterImpl implements NumberStringConverter {

    @Override
    public long[] convert(String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .mapToLong(numberString -> {
                    try {
                        long number = Long.parseLong(numberString);

                        if (number < 0L) {
                            throw new IllegalArgumentException(Message.INCLUDE_NEGATIVE_NUMBER.getMessage() + number);
                        }

                        return number;
                    } catch (NumberFormatException e) {
                        if (numberString.isEmpty()) {
                            return 0L;
                        }

                        if (canConvertToBigInteger(numberString)) {
                            throw new IllegalArgumentException(Message.TOO_BIG_NUMBER.getMessage() + numberString);
                        }

                        throw new IllegalArgumentException(Message.INCLUDE_NOT_NUMBER.getMessage() + numberString);
                    }
                })
                .toArray();
    }

    @Override
    public boolean canConvertToBigInteger(String numberString) {
        try {
            new BigInteger(numberString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
