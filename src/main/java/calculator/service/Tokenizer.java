package calculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Tokenizer {

    private final List<NumberSeparator> numberSeparators = new ArrayList<>();
    private String targetNumberInput;

    public Tokenizer(final String inputNumbers, final SeparatorFactory separatorFactory) {
        targetNumberInput = inputNumbers;
        numberSeparators.addAll(separatorFactory.getSeparators());
    }

    public Tokenizer(final String inputNumbers) {
        targetNumberInput = inputNumbers;
    }

    public Numbers tokenize() {
        final List<Number> numbers = new ArrayList<>();

        final int nextSeparatorIndex = findNextSeparatorIndex(this.targetNumberInput);
        final String startNumber = targetNumberInput.substring(0, nextSeparatorIndex);
        targetNumberInput = targetNumberInput.substring(nextSeparatorIndex);
        numbers.add(new Number(startNumber));

        while (true) {
            final Number number = next();
            if (Objects.isNull(number)) {
                break;
            }
            numbers.add(number);
        }
        return new Numbers(numbers);
    }

    Number next() {
        if (targetNumberInput.isBlank()) {
            return null;
        }
        final NumberSeparator selectedSeparator = selectAvailableSeparator(this.targetNumberInput);
        targetNumberInput = selectedSeparator.extract(targetNumberInput);

        final int currentNumberLastIndex = findNextSeparatorIndex(targetNumberInput);
        final Number number = new Number(targetNumberInput.substring(0, currentNumberLastIndex));
        this.targetNumberInput = targetNumberInput.substring(currentNumberLastIndex);
        return number;
    }

    private int findNextSeparatorIndex(final String target) {
        for (int i = 0; i < targetNumberInput.length(); i++) {
            if (selectAvailableSeparator(target.substring(i)) != null) {
                return i;
            }
        }
        return target.length();
    }

    private NumberSeparator selectAvailableSeparator(final String targetString) {
        int largestSeparator = -1;
        NumberSeparator selectedSeparator = null;
        for (final NumberSeparator separator : numberSeparators) {
            if (separator.available(targetString) && largestSeparator < separator.getLength()) {
                largestSeparator = separator.getLength();
                selectedSeparator = separator;
            }
        }
        if (largestSeparator == -1) {
            return null;
        }
        return selectedSeparator;
    }

    public void addSeparator(final NumberSeparator numberSeparator) {
        this.numberSeparators.add(numberSeparator);
    }
}
