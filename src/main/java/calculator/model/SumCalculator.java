package calculator.model;

public class SumCalculator {
    private final NumberValidator numberValidator;

    public SumCalculator() {
        this.numberValidator = new NumberValidator();
    }

    public int calculateSum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            if (number.isEmpty()) {
                number = "0";
            }
            total += numberValidator.validateAndParse(number);
        }
        return total;
    }
}
