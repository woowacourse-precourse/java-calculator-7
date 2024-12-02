package calculator;

import java.util.List;

public class Calculator {
    private List<Integer> numbers;

    public Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sum() {
        Integer result = 0;

        result = numbers.stream()
                .reduce(result, Integer::sum);

        return result;
    }

//    private boolean isSpecialCharacter(String str) {
//        if (str.matches(Regex.SPECIAL_CHARACTER_REGEX.getPattern())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
