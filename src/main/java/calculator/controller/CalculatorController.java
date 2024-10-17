package calculator.controller;

import calculator.controller.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CalculatorController {

    public void start() {
        String input = InputView.getDelimiterAndNumbers();

        Stream<Integer> numbers = Stream.empty();
        List<String> delimiters = new ArrayList<>();
        List<String> numStrs = new ArrayList<>();


        if (startsWithNumber(input)) {
            String[] stringArray = input
                    .replaceAll("[,|:]", " ")
                    .split(" ");

            for (int i = 0; i < stringArray.length; i++) {
                if (i % 2 == 0) {
                    numStrs.add(stringArray[i]);
                } else {
                    delimiters.add(stringArray[i]);
                }
            }

            boolean useProperDelimiter = delimiters.stream()
                    .allMatch(delimiter -> delimiter.equals(",") || delimiter.equals(":"));
            if(useProperDelimiter) {
                numbers = convertToInt(numStrs);
            } else {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
            }
        } else {
            // check the format of "//;\n1;2;3"
            String newDelimiter = extractNewDelimiter(input);
            numbers = Arrays.stream(
                    input.substring(newDelimiter.length() + 4).split(newDelimiter)
                    )
                    .map(Integer::parseInt);
        }
        int sum = numbers.reduce(0, Integer::sum);
        System.out.println("결과 : " + sum);
    }

    private String extractNewDelimiter(String str) {
        checkInputFormat(str);
        int delimiterIndex = str.indexOf("\\n");
        return str.substring(2, delimiterIndex);
    }

    private void checkInputFormat(String str) {
        if(!str.startsWith("//")) throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        if(!str.contains("\\n")) throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
    }

    private boolean startsWithNumber(String str) {
        String first = String.valueOf(str.charAt(0));
        return first.matches("[0-9]+");
    }

    private Stream<Integer> convertToInt(List<String> strs) {
        return strs.stream().map(Integer::parseInt);
    }

    public static void main(String[] args) {
        var version = "Java 23";
        String str = "33,1:2";
        String result = str.replaceAll("[,|:]", " ").replace(":", " ");;
        System.out.println(result);

    }
}


