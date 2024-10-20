package calculator.adapter;


import calculator.application.DelimiterList;
import calculator.domain.Number;
import calculator.domain.NumberList;

import java.util.ArrayList;
import java.util.Arrays;

public final class Convertor {
    private static final String START_REGEX = "[";
    private static final String END_REGEX = "]";

    public NumberList convertToNumberList(final String value, final DelimiterList delimiterList) {
        final var regex = createRegex(delimiterList);
        return createNumberList(value, regex);
    }

    private String createRegex(final DelimiterList delimiterList) {
        final var sb = new StringBuilder();

        sb.append(START_REGEX);
        delimiterList.forEach(e -> sb.append(e.value()));
        sb.append(END_REGEX);

        return sb.toString();
    }

    private NumberList createNumberList(final String value, final String regex) {
        final var split = value.split(regex);
        final var list = new ArrayList<Number>();

        Arrays.stream(split)
            .forEach(e -> list.add(pareLong(e)));

        return new NumberList(list);
    }

    private Number pareLong(final String value) {
        try {
            final var result = Long.parseLong(value);
            return new Number(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}