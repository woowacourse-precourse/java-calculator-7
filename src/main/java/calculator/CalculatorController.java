package calculator;

public class CalculatorController {

    private final Calculator calculator = new Calculator();

    public int processInput(String input) {
        String[] parts = input.split("\\\\n");
        String[] numbers = getSeparatedNumbers(parts);

        return calculator.getTotal(numbers);
    }


    private String[] getSeparatedNumbers(String[] parts) {
        String separator = "[,:]";
        String numbers = parts[0];

        if (isCustomSeparator(parts)) {
            String custom = getCustomSeparator(parts[0]);

            separator = "[,:" + custom + "]";
            numbers = parts[1];
        }
        return numbers.split(separator);
    }

    private boolean isCustomSeparator(String[] parts) {

    }

    private String getCustomSeparator(String part) {

    }
}