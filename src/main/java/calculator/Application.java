package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        String delimiters = ":,";
        String validTarget = input;
        String escapedDelimiters = delimiters;

        if (hasCustomDelimiter(input)) {
            delimiters = getCustomDelimiter(input);
            validTarget = extractNumbersSection(input);
            escapedDelimiters = escapeSpecialCharacters(delimiters);
        }

        if (!isValidInput(validTarget, escapedDelimiters)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }

        int sumResult = sumNumbers(validTarget, escapedDelimiters);

        System.out.println("결과 : " + sumResult);
    }

    private static boolean isValidInput(String validTarget, String delimiters) {
        if (validTarget.isBlank()) {
            return true;
        }

        String regex = "^\\d+(" + "[" + delimiters + "]" + "\\d+)*$";
        return validTarget.matches(regex);
    }

    private static String extractNumbersSection(String input) {
        return input.substring(input.indexOf("\\n") + 2);
    }

    private static String escapeSpecialCharacters(String delimiter) {
        StringBuilder escapedDelimiter = new StringBuilder();

        for (char ch : delimiter.toCharArray()) {
            if ("|*+()[]{}.^$\\&".indexOf(ch) != -1) {
                escapedDelimiter.append("\\"); // 이스케이프 문자 추가
            }
            escapedDelimiter.append(ch);
        }

        return escapedDelimiter.toString();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && (input.indexOf("\\n") == input.indexOf("//") + 3);
    }

    private static String getCustomDelimiter(String input) {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");

        return input.substring(startIndex, endIndex);
    }

    private static int sumNumbers(String input, String delimiters) {
        String regDelimiters = "[" + delimiters + "]";
        String[] extractedNums = input.split(regDelimiters);

        int sum = 0;

        for (String num : extractedNums) {
            if (!num.isBlank()) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }
}
