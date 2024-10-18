package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private List<Integer> numbers = new ArrayList<>();
    private String[] delimiter = new String[]{",", ":"};

    public StringCalculator(String input) {
        this.numbers = split(input);
    }

    public int calculate() {
        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        return result;
    }

    public void addCustomDelimiter(String input, int endIndex) {
        String delimiterPart = input.substring(2, endIndex);
        String[] customDelimiters = delimiterPart.split("\\|");
        this.delimiter = mergeDelimiters(delimiter, customDelimiters);
    }

    private String[] mergeDelimiters(String[] baseDelimiters, String[] customDelimiters) {
        String[] merged = Arrays.copyOf(baseDelimiters, baseDelimiters.length + customDelimiters.length);
        System.arraycopy(customDelimiters, 0, merged, baseDelimiters.length, customDelimiters.length);
        return merged;
    }

    public List<Integer> split(String input) {
        List<Integer> numberList = new ArrayList<>();

        if (input.startsWith("//") && input.contains("\\n")) {
            int endIndex = input.indexOf("\\n");
            addCustomDelimiter(input, endIndex);
            input = input.substring(endIndex + 2);
        }

        numberList.addAll(
                Arrays.stream(input.split(String.join("|", delimiter)))
                        .map(Integer::parseInt)
                        .toList()
        );

        return numberList;
    }
}
