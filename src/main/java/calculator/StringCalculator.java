package calculator;

public class StringCalculator {
    private final Delimiter delimiter = new Delimiter();
    private final NumberAdder numberAdder = new NumberAdder();

    public long add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = delimiter.split(input);
        return numberAdder.add(numbers);
    }
}
