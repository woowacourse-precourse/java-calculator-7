package calculator.util;

public class IntegerParser {
    public int parse(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e) {
            throw new NumberFormatException(number);
        }
    }
}
