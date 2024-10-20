package calculator;

public class Calculator {
    private final Adder adder;
    private final Delimiters delimiters;

    public Calculator(Adder adder, Delimiters delimiters) {
        this.adder = adder;
        this.delimiters = delimiters;
    }

    public int calculate(String input) {

        if (input == null || input.isBlank()) {
            return 0;
        }

        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }

        // 쉼표, 콜론으로 숫자 분리
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = delimiters.defaultDelimiter(input);
            return adder.sumNumbers(numbers);
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            String[] numbers = delimiters.customDelimiter(input);
            return adder.sumNumbers(numbers);
        }
        throw new IllegalArgumentException();
    }
}