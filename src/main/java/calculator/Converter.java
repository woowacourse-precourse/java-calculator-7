package calculator;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<Integer> convert(String[] strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : strings) {
            isInteger(s);
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static void isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 문자열이 포함되어 있습니다.");
        }
    }
}
