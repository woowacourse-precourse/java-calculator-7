package calculator;

public class CalculatorController {

    private final Calculator calculator = new Calculator();

    public int processInput(String input) {
        String[] parts = input.split("\\\\n");
        String[] numbers = getSeparatedNumbers(parts);

        checkNumbersNull(numbers);

        return calculator.getTotal(numbers);
    }

    private void checkNumbersNull(String[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("숫자 X");
        }
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
        return parts.length == 2 && parts[0].startsWith("//");
    }

    private String getCustomSeparator(String part) {
        if (part.length() != 3) {
            throw new IllegalArgumentException("커스텀 구분자 입력 길이 틀림");
        }
        return Character.toString(part.charAt(2));
    }
}