package calculator.model;

import java.util.List;

public record InputString(
    String input,
    String splitString,
    List<String> numberList) {

    public boolean isNumber(List<String> numberList) {
        for (String number : numberList) {
            try {
                Integer.valueOf(number);
                if (number.contains("-")) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return input.isEmpty();
    }
}
