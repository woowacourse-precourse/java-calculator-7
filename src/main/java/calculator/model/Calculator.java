package calculator.model;

public class Calculator {
    public static String[] separateNumber(String input, String delimiter) {
        String[] numberGroup = input.split(delimiter);
        return numberGroup;
    }
}
