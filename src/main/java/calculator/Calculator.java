package calculator;

public class Calculator {

    public int calculation(String req, String[] separator) {

        String input = req;

        if (separator != null && separator.length == 2) {
            input = separator[0];
            input = input.replace(separator[1], "");
        }

        input = input.replace(",", "");
        input = input.replace(":", "");

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }

        int sum = input.chars()
                .map(Character::getNumericValue)
                .sum();

        return sum;
    }
}
