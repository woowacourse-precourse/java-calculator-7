package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

/* TODO: Expression 객체로 변환,
 *  생성자에서 parse하게 하고, of(), getDelimiters(), getOperands() 구현
 */
public class ExpressionInputReader {
    
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final Set<String> delimiters = new HashSet<>();
    private int startIndex = 0;

    public Set<String> getDelimiters() {
        return delimiters;
    }

    public String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        System.out.println("input = " + input);
        if (input.isBlank()) {
            Console.close();
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            extractCustomDelimiter(input);
        }

        Console.close();
        return input.substring(startIndex);
    }

    private void extractCustomDelimiter(String input) {

        while (input.startsWith(CUSTOM_DELIMITER_PREFIX, startIndex)) {
            startIndex += CUSTOM_DELIMITER_PREFIX.length();

            int endIndex = input.indexOf(CUSTOM_DELIMITER_SUFFIX, startIndex);
            final String candidate = input.substring(startIndex, endIndex);
            if (candidate.contains(CUSTOM_DELIMITER_PREFIX)) {
                Console.close();
                throw new IllegalArgumentException("커스텀 구분자에 " + CUSTOM_DELIMITER_PREFIX + "는 포함할 수 없습니다.");
            }
            delimiters.add(candidate);

            startIndex = endIndex + CUSTOM_DELIMITER_SUFFIX.length();
        }

    }

    public void clearDelimiters() {
        delimiters.clear();
    }
}
