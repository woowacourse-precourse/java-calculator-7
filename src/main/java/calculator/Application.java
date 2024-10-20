package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Application {

    private static HashSet<Character> delimiters = new HashSet<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = "";
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
        }

        int result = calc(input);

        System.out.println("결과 : " + result);
    }

    private static int calc(String input) {
        int result = 0;
        initDelimiter();

        result = getResult(input, result);

        return result;
    }

    private static boolean isCustom(String input, String start, char char1, char char2) {
        return input.startsWith(start) &&
                input.charAt(3) == char1 &&
                input.charAt(4) == char2;
    }

    private static boolean expressValidation(String input) throws IllegalArgumentException {
        String delimiter = getDelimitersToString();
        return Pattern.matches("(\\d+([" + delimiter + "]\\d+)*|\\d+([" + delimiter + "]\\d+)*)?|", input);
    }

    private static int getResult(String input, int result) {
        String inputAdapter = input;
        if (isCustom(input, "//", '\\', 'n')) {
            addDelimiter(input.charAt(2));
            inputAdapter = input.substring(5);
        }

        try {
            expressValidation(inputAdapter);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "잘못된 입력입니다.");
        }

        String[] numbers = splitInput(inputAdapter);

        for (String number : numbers) {
            if (!number.isEmpty()) {
                result += validValue(number);
            }
        }
        return result;
    }

    private static String[] splitInput(String input) {
        StringBuilder builder = new StringBuilder();
        for (Character delimiter : delimiters) {
            if (!builder.isEmpty()) {
                builder.append("|");
            }
            builder.append("\\").append(delimiter);
        }

        return input.split(builder.toString());
    }

    private static void initDelimiter() {
        delimiters.add(',');
        delimiters.add(':');
    }

    private static void addDelimiter(char charDelimiter) {
        if (validCharacter(charDelimiter)) {
            delimiters.add(charDelimiter);
        }
    }

    private static boolean validCharacter(char character) {
        if ((33 <= character && character <= 47) || (58 <= character && character <= 63)) {
            return true;
        }
        throw new IllegalArgumentException("잘못된 기호가 들어갔습니다.");
    }

    public static int validValue(String value) {
        int integerValue = Integer.parseInt(value);
        if (integerValue >= 0) {
            return integerValue;
        }
        throw new IllegalArgumentException("음수의 값이 들어왔습니다.");
    }

    public static String getDelimitersToString() {
        StringBuilder result = new StringBuilder();
        for (Character delimiter : delimiters) {
            result.append(delimiter);
        }
        return result.toString();
    }
}