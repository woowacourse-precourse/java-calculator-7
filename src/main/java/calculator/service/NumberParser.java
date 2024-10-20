package calculator.service;

import calculator.dto.CalculatorRequest;
import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public static List<Integer> parseByDelimiters(CalculatorRequest request) {
        String calculation = request.calculation();
        String delimiters = request.delimiters();

        if (calculation.isEmpty()) {
            return List.of(0);
        }

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
        try {
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다: " + number);
        }
    }
}
