package calculator.model;

import calculator.view.Message;
import java.util.Arrays;

public class NumberStringConverterImpl implements NumberStringConverter {

    @Override
    public long[] convert(String[] numberStrings) {
        String LongMaxValue = String.valueOf(Long.MAX_VALUE);

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
                        if (numberString.compareTo(LongMaxValue) > 0) {
                            throw new IllegalArgumentException(Message.TOO_BIG_NUMBER.getMessage() + numberString);
                        }

                        throw new IllegalArgumentException(Message.INCLUDE_NOT_NUMBER.getMessage() + numberString);
                    }
                })
                .toArray();
    }
}
