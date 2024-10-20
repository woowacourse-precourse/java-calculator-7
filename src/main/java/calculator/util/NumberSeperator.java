package calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberSeperator {
    public static List<Integer> parseNumbersFromDelimitedString(Set<String> separator, String input) {
        String[] numbers = input.split(String.join("|", separator));

        if (numbers.length == 0) {
            throw new IllegalArgumentException("입력된 숫자가 없습니다.");
        }
        List<Integer> parseNumber = new ArrayList<>();
        for (String number : numbers) {
            try {
                if(number.equals("")){
                    throw new IllegalArgumentException("숫자 값이 비어있습니다.");
                }
                int result = Integer.parseInt(number);

                if (result < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                parseNumber.add(result);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함 되어 있습니다.");
            }
        }
        return parseNumber;
    }
}
