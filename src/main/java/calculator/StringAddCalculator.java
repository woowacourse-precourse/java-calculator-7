package calculator;

public class StringAddCalculator {

    private final InputValidator validator = new InputValidator();
    private final Converter converter = new Converter();
    private static final String SEPARATOR = ",|:";

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] stringArr = converter.toStringArr(input);

        int sum = 0;
        for (String s : stringArr) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

}
