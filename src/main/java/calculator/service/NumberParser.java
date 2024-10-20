package calculator.service;

import calculator.dto.CalculatorRequest;
import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public static List<Integer> parseByDelimiters(CalculatorRequest request) {
        String calculation = request.calculation();
        String delimiters = request.delimiters();

        String[] tokens = splitByDelimiters(calculation, delimiters);
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            int number = parseToInt(token);
            numbers.add(number);
        }
        return numbers;
    }

    private static String[] splitByDelimiters(String calculation, String delimiters) {
        return calculation.split(delimiters);
    }

    private static int parseToInt(String number) {
        return Integer.parseInt(number.trim());
    }
}
