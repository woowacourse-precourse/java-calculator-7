package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.inputString();
        String numberPart = Input.validateInput(input);
        List<String> separators = Input.extractSeparator(input);
        List<String> numbers = Sum.extractNumber(numberPart, separators);
        Integer totalSum = Sum.calculate(numbers);
    }
}

class Input {
    public static String inputString() {
        System.out.println("Please enter the strings to add.");
        return Console.readLine();
    }

    public static String validateInput(String input) {
        if (input.isBlank())
            throw new IllegalArgumentException("Blank InputString Error");

        String numberPart = input;
        String separtor = "";

        if (input.startsWith("//") && input.contains("\\n")) {
            separtor = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
            if (separtor.length() != 1)
                throw new IllegalArgumentException("Separator format is invalid");
            else
                numberPart = input.substring(input.indexOf("\\n") + 2);
        }

        List<String> separators = new java.util.ArrayList<>(List.of(",", ":"));
        if(!separtor.isEmpty()) separators.add(separtor);

        for (int i = 0; i < numberPart.length(); i++) {
            if (!separators.contains(String.valueOf(numberPart.charAt(i)))
                    && (numberPart.charAt(i) < '0' || numberPart.charAt(i) > '9'))

                throw new IllegalArgumentException("Number part is invalid");
        }

        return numberPart;
    }

    public static List<String> extractSeparator(String input) {
        if (input.startsWith("//"))
            return List.of(",", ":", input.substring(2, 3));
        else
            return List.of(",", ":");
    }
}

class Sum {
    public static List<String> extractNumber(String numberPart, List<String> separators) {
        String separatorPattern = separators.stream()
                .map(Pattern::quote)  // 각 구분자를 이스케이프 처리
                .reduce((a, b) -> a + "|" + b)  // |로 결합
                .orElse(",");

        // 정규식 패턴에 맞춰서 split
        return List.of(numberPart.split(separatorPattern));
    }

    public static Integer calculate(List<String> numbers) {
        int total = 0;

        for (String number : numbers) {
            total += Integer.parseInt(number);
        }

        return total;
    }
}