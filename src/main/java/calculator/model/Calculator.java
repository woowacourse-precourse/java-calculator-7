package calculator.model;

public class Calculator {
    private final int result;

    public Calculator(InputManager inputManager) {
        this.result = calculateSum(inputManager);
    }

    public int getResult() {
        return result;
    }

    public int calculateSum(InputManager inputManager) {

        return inputManager.stringToIntegers().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
