package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
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

    public boolean isOriginEmpty() {
        return origin.isEmpty();
    }

    public List<Integer> getNumbers() {
        if (!isNumber(numbers)) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    public Input makeInputWithSeparator() {
        return new Input(origin.substring(5), "[,:" + origin.charAt(2) + "]", numbers);
    }

    public Input makeInputWithoutSeparator() {
        return new Input(origin.substring(4), separator, numbers);
    }

    public Input makeInputWithoutOrigin() {
        return new Input(origin, separator, List.of("0"));
    }

    public Input makeInputWithOrigin() {
        List<String> numbers = Arrays
                .stream(origin.split(separator))
                .toList();
        return new Input(origin, separator, numbers);
    }

    public boolean isAgainstCustomLengthRule() {
        return origin.length() < 4;
    }

    public boolean hasCustomSeparator() {
        return origin.indexOf("//") == 0 && origin.indexOf("\\n") == 3;
    }

    public boolean notHasCustomSeparator() {
        return origin.indexOf("//") == 0 && origin.indexOf("\\n") == 2;
    }
}
