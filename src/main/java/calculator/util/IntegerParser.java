package calculator.util;

class IntegerParser {
    public int parse(String number) {
        if (number.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
