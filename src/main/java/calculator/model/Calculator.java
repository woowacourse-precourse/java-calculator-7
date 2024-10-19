package calculator.model;

public class Calculator {

    public Number sumNumbersFromString(String input) {
        if (isBlank(input)) {
            return Number.from("0");
        }

        Separator separator = new Separator();
        String[] numberStrings = separator.splitByAllSeparators(input);

        Numbers numbers = Numbers.from(numberStrings);
        Number number = numbers.sumNumbers();

        return number;
    }

    private boolean isBlank(String input) {
        return input.isEmpty();
    }
}
