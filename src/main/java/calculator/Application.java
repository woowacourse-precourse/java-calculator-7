package calculator;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        Set<String> delimiters = new HashSet<>(Set.of(",", ":"));
        List<Integer> numbers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        if (input.contains("//") && input.contains("\\n")) {
            if (!input.startsWith("//")) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            String customDelimiter = input.split("\\\\n")[0].split("//")[1];
            if (customDelimiter.contains("\\")) {
                throw new IllegalArgumentException("이스케이프 문자가 포함되었습니다.");
            } else if (customDelimiter.matches(".*\\d.*")) {
                throw new IllegalArgumentException("커스텀 구분자엔 숫자가 포함될 수 없습니다.");
            }
            delimiters.add(customDelimiter);
            input = input.split("\\\\n")[1];
        }

        String[] numberTokens = input.split(String.join("|", delimiters));

        for (String token : numberTokens) {
            int number = token.isEmpty() ? 0 : Integer.parseInt(token);
            numbers.add(number);
        }
    }
}
