package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String division = " ";
    private final List<Integer> numbers = new ArrayList<>();

    public void getDivision(String inputString) {
        if (inputString.startsWith("//")) {
            String[] strings = inputString.split("\n");
            division = strings[0].substring(2);
        }
    }

    public void getNumbers(String inputString) {
        String[] customStrings = inputString.split(division);
        List<String> strings;

        for (String customString : customStrings) {
            strings = Arrays.asList(customString.split(",|:"));
            for (String string : strings) {
                numbers.add(Integer.parseInt(string));
            }
        }
    }

    public int calculateNumber() {
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result; // 계산 결과값 반환
    }
}
