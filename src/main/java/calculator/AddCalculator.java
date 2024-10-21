package calculator;

import java.util.List;

public class AddCalculator {

    private static Double sum;

    public static double add(double number) {
        return number;
    }

    public static void add(double a, double b) {
        sum = a + b;
    }

    public static double sum() {
        return sum;
    }

    public static void add(List<Double> numbers) {
        sum = numbers.stream().mapToDouble(AddCalculator::add).sum();
    }
}
