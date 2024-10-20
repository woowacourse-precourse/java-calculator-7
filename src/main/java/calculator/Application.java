package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String[] checkInput (String input, StringBuilder delimiter) {
        String processedInput = extractCustomDelimiter(input, delimiter);
        if (!validateInput(processedInput, delimiter)) {
            throw new IllegalArgumentException("wrong arguments");
        }
        return checkDuplicateDelimiter(processedInput.split(delimiter.toString()));
    }

    public static String extractCustomDelimiter(String input, StringBuilder delimiter) {
        String processedInput = input;
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("custom delimiter error");
            }
            delimiter.append(input, 2, delimiterEndIndex);
            processedInput = input.substring(delimiterEndIndex + 2);
        }
        delimiter.append("]");
        return processedInput;
    }

    public static boolean validateInput(String input, StringBuilder delimiter) {
        String regex = "^[0-9" + delimiter.substring(1) + "+$";
        return input.matches(regex);
    }

    public static String[] checkDuplicateDelimiter (String[] splitInput) {
        for (String str : splitInput) {
            if (str.equals("")) {
                throw new IllegalArgumentException("delimiter duplicate");
            }
        }
        return splitInput;
    }

    public static int calculateSum(String[] splitInput) {
        int sum = 0;
        for (String input : splitInput) {
            sum += Integer.parseInt(input);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        StringBuilder delimiter = new StringBuilder("[,:");
        String input = Console.readLine();
        String[] splitInput = checkInput(input, delimiter);
        System.out.println("결과 : " + calculateSum(splitInput));
    }
}
