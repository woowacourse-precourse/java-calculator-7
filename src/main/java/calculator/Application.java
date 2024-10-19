package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

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

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("문자열 입력하지 않음");
        }

        boolean hasCustomDelimiter = hasCustomDelimiter(input);
        HashSet<String> delimiters = getDelimiters(input, hasCustomDelimiter);
    }
}
