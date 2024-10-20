package calculator;

public class StringCalculator {
    public static int add(String input) {
        if (EmptyInputHandler.isEmptyOrNull(input)) {
            return 0;
        }

        if (input.startsWith("//")) {
            return CustomDelimiterCalculator.calculateSum(input);
        }

        return StandardDelimiterCalculator.calculateSum(input);
    }
}
