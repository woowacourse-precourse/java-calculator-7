package calculator;

public class Validator {

    public static double validateNumber(String numberStr) {
        try {
            double number = Double.parseDouble(numberStr);
            if (number <= 0.0)
                throw new IllegalArgumentException("양수가 아닙니다.");

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자열이 올바른 숫자 형식이 아닙니다.");
        }
    }
}
