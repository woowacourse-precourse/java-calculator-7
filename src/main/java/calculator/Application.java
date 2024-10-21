package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String customDelimiter = getCustomDelimiter(input);
        if (customDelimiter != null) {
            String delimiterRemovedInput = input.substring(customDelimiter.length() + 5);
            String[] splitInput = delimiterRemovedInput.split(customDelimiter + "|" + "," + "|" + ":");
            List<Integer> numbers = parseIntegers(splitInput);
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            System.out.println("결과 : " + sum);
        } else {
            String[] splitInput = input.split("[,:]");
            List<Integer> numbers = parseIntegers(splitInput);
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            System.out.println("결과 : " + sum);
        }
    }

    public static String getCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            if (input.contains("\\n")) {
                return input.substring(input.indexOf("//") + 2, input.indexOf("\\n") - 1);
            }
            throw new IllegalArgumentException();
        }
        return null;
    }

    public static List<Integer> parseIntegers(String[] input) {
        try {
            return Arrays.stream(input).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
