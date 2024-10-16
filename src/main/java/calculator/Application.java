package calculator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        Set<String> delimiters = new HashSet<>(Set.of(",", ":"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        if (input.contains("//") && input.contains("\\n")) {
            String customDelimiter = input.split("\\\\n")[0].split("//")[1];
            delimiters.add(customDelimiter);
            input = input.split("\\\\n")[1];
        }

        String[] numberTokens = input.split(String.join("|", delimiters));
    }
}
