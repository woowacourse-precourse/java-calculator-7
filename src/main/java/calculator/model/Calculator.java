package calculator.model;
import java.util.List;

public class Calculator {
    public double calculatorSum(List<Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }
}