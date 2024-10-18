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

    public static Input makeInputWithSeparator(Input input) {
        return new Input(input.origin.substring(5), "[,:" + input.origin.charAt(2) + "]",
                input.numbers());
    }

    public static Input makeInputWithoutSeparator(Input input) {
        return new Input(input.origin.substring(4), input.separator(),
                input.numbers());
    }

    public static Input makeInputWithoutOrigin(Input input) {
        return new Input(input.origin(), input.separator(), List.of("0"));
    }

    public static Input makeInputWithOrigin(Input input, List<String> numbers) {
        return new Input(input.origin(), input.separator(), numbers);
    }
}
