package calculator.model;

import java.util.ArrayList;
import java.util.List;

public record Input(
        String origin,
        String separator,
        List<String> numbers) {

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
        return origin.isEmpty();
    }

    public List<Integer> getNumbers() {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
