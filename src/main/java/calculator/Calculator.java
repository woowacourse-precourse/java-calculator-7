package calculator;

public class Calculator {

    private Calculator() {
    }

    public static Number calculateSum(Numbers numbers) {
        Number sumResult = Number.zero();
        for (int index = 0; index < numbers.size(); index++) {
            sumResult.plus(numbers.findByIndex(index));
        }
        return sumResult;
    }
}
