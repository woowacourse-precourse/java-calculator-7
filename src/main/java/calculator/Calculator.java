package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private String division;
    private final List<Integer> numbers = new ArrayList<>();

    public void getDivision(String inputString) {
        if (inputString != null && inputString.startsWith("//")) {
            division = inputString.replace("//", "");
        }
    }

    public void getNumbers(String inputString) {
        String regex;

        if (division != null) {
            regex = ",|" + division + "|:";
        } else {
            regex = ",|;";
        }
        List<String> strings = Arrays.asList(inputString.split(regex));

        for (String string : strings) {
            int number = Integer.parseInt(string);
            numbers.add(Integer.parseInt(string));
        }
    }

    public int calculateNumber() {
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result; // 계산 결과값 반환
    }

    public Map<String, String> split(String inputString) {
        Map<String, String> splitString = new HashMap<>();

        if (inputString.startsWith("//")) {
            int index = inputString.indexOf("\\n");

            splitString.put("division", inputString.substring(0, index));
            splitString.put("number", inputString.substring(index + 2));
        } else {
            splitString.put("division", null);
            splitString.put("number", inputString);
        }

        return splitString;
    }
}
