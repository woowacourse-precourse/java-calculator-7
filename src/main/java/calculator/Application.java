package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public static HashSet<String> getDelimiters(String input, boolean hasCustomDelimiter) {
        HashSet<String> delimiters = new HashSet<>();
        delimiters.add(",");
        delimiters.add(":");

        if (hasCustomDelimiter) {
            String delimiter = input.substring(2, input.indexOf("\\n"));
            delimiters.add(delimiter);
        }

        return delimiters;
    }

    public static ArrayList<String> getNumbers(String input, HashSet<String> delimiters) {
        String numberString = input;
        if (hasCustomDelimiter(input)) {
            numberString = input.substring(input.indexOf("\\n") + 2);
        }
        for (String delimiter : delimiters) {
            numberString = numberString.replace(delimiter, ",");
        }

        return new ArrayList<>(List.of(numberString.split(",")));
    }

    public static boolean isValidNumbers(ArrayList<String> numbers) {
        for (String number : numbers) {
            if (!number.matches("^[0-9]*$")) {
                throw new IllegalArgumentException("숫자가 아닌 문자 포함");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열 입력하지 않음");
        }

        boolean hasCustomDelimiter = hasCustomDelimiter(input);
        HashSet<String> delimiters = getDelimiters(input, hasCustomDelimiter);
        ArrayList<String> numbers = getNumbers(input, delimiters);
    }
}
