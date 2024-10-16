package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class ExpressionInputReader {
    
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    private final Set<String> delimiters = new HashSet<>();

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        if (input.isBlank()) {
            Console.close();
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        while (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            extractCustomDelimiter(input);
            input = Console.readLine();
        }
        Console.close();

        return input;
    }

    private void extractCustomDelimiter(String input) {
        final String prefixDeleted = input.substring(CUSTOM_DELIMITER_PREFIX.length());
        if (prefixDeleted.contains(CUSTOM_DELIMITER_PREFIX)) {
            Console.close();
            throw new IllegalArgumentException("커스텀 구분자에 " + CUSTOM_DELIMITER_PREFIX + "는 포함할 수 없습니다.");
        }

        delimiters.add(prefixDeleted);
    }

    public void clearDelimiters() {
        delimiters.clear();
    }
}
