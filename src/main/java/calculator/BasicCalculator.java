package calculator;

public class BasicCalculator implements Calculator {
    private final Separator separator;
    private final Numbers numbers;

    public BasicCalculator(String input) {
        this.separator = new Separator(input);
        this.numbers = new Numbers(input);
    }

    public int calculate(String operation) {
        switch (operation) {
            case "add":
                return add();
            case "sub":
                return sub();
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private int add() {
        String[] nums = numbers.getNumbers().split(separator.makeSeparatorsForSplit());
        int sum = 0;
        for (String n : nums) {
            sum += Integer.parseInt(n);
        }
        return sum;
    }

    private int sub() {
        return 0;
    }

}
