package calculator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Tokenizer {

    private final List<NumberSeparator> numberSeparators = new ArrayList<>();
    private String targetNumberInput;

    Tokenizer(final UserInputNumbers userInputNumbers, final SeparatorFactory separatorFactory) {
        targetNumberInput = userInputNumbers.getNumbers();
        numberSeparators.addAll(separatorFactory.getSeparators());
    }

    Tokenizer(final UserInputNumbers userInputNumbers) {
        targetNumberInput = userInputNumbers.getNumbers();
    }

    Numbers tokenize() {
        if (this.targetNumberInput.isBlank()) {
            return new Numbers(List.of(new Number("0")));
        }

        final List<Number> numbers = new ArrayList<>();

        final Number firstNumber = findFirstNumber();
        numbers.add(firstNumber);

        while (true) {
            final Number number = next();
            if (Objects.isNull(number)) {
                break;
            }
            numbers.add(number);
        }
        return new Numbers(numbers);
    }

    private Number findFirstNumber() {
        final int nextSeparatorIndex = findNextSeparatorIndex(this.targetNumberInput);
        final String startNumber = targetNumberInput.substring(0, nextSeparatorIndex);
        targetNumberInput = targetNumberInput.substring(nextSeparatorIndex);
        return new Number(startNumber);
    }

    private Number next() {
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
        NumberSeparator selectedSeparator = null;
        for (final NumberSeparator separator : numberSeparators) {
            if (separator.available(targetString)) {
                selectedSeparator = separator;
            }
        }
        if (Objects.isNull(selectedSeparator)) {
            return null;
        }
        return selectedSeparator;
    }

    void addSeparator(final NumberSeparator numberSeparator) {
        this.numberSeparators.add(numberSeparator);
    }
}
