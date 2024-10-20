package calculator.model;

public class NumberValidator {

    public int validateAndParse(String number) {
        int result = Integer.parseInt(number);
        return result;
    }
}
