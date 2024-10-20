package calculator.service;

import java.util.List;

public class Calculator {

    public static double sum(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }

}