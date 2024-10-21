package calculator.model;

import java.util.Arrays;

public class Calculator {
    public int calc(String input) throws IllegalArgumentException {
            int[] arr = validateInput(input);

            if (arr.length == 1) {
                return sum(new int[]{0, arr[0]});
            }

            return sum(arr);
    }
    public int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }
    private int[] validateInput(String input) throws IllegalArgumentException{
        String delimiter = null;

        if(input.contains("//") && input.contains("\\n")){
            delimiter = extractCustomDelimiter(input);
            input = input.replace("//" + delimiter + "\\n", "");
        }else if(input.contains(",")){
            delimiter = ",";
        }else if(input.contains(".")){
            delimiter = ".";
        }else{
            throw new IllegalArgumentException("구분자를 지정해야 합니다.");
        }

        return parseNumbers(input, delimiter);
    }

    private String extractCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n", startIndex);
        return input.substring(startIndex, endIndex);
    }

    private int[] parseNumbers(String input, String delimiter) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
        String[] stringNumbers = input.split(delimiter);
        return convertToIntArray(stringNumbers);
    }

    private int[] convertToIntArray(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
