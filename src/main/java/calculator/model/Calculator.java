package calculator.model;

public class Calculator {
    public int calculateSum(Numbers numbers) {
        return numbers.getNumbers().stream().mapToInt(number -> number).sum();
    } // calculateSum
} // class