package calculator.util;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorUtils {

    // 사용자에게 문자열 입력받아서 반환
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        // 사용자가 개행이 아닌 "\"와 "n"을 붙여서 입력한 것을 올바르게 처리하기 위해 replace합니다.
        return input.replace("\\n", "\n");
    }

    // userInput에서 커스텀 구분자를 추출해서 separators에 추가
    public static void extractSeparators(Set<Character> separators, String userInput) {
        if (userInput.length() < 2 || userInput.charAt(0) != '/' || userInput.charAt(1) != '/') {
            return;
        }
        for (int i = 2; i < userInput.length(); i++) {
            char ch = userInput.charAt(i);
            // 커스텀 구분자 부분이 끝난 경우 return
            if (ch == '\n') {
                return;
            }
            // 커스텀 구분자 separators에 추가
            separators.add(ch);
        }
    }

    // 사용자 입력이 올바른 형식인지 체크
    public static void checkInputFormat(String userInput, Set<Character> separators) {
        String[] split = userInput.split("\n");
        Pattern pattern = makePattern(separators);

        if (split.length == 0) {
            return;
        }
        if (split.length > 2) {
            throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
        }
        // split의 길이가 1 또는 2
        if (userInput.contains("\n")) {
            String customSeparator = split[0];
            if (customSeparator.charAt(customSeparator.length() - 1) == '\n') {
                throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
            } else if (customSeparator.length() < 2) {
                throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
            } else if (customSeparator.charAt(0) != '/' || customSeparator.charAt(1) != '/') {
                throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
            }
        }
        if ((split.length == 1 && !userInput.contains("\n")) && !pattern.matcher(userInput).matches()) {
            throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
        }
        if (split.length == 2 && !pattern.matcher(split[1]).matches()) {
            throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
        }
    }
    private static Pattern makePattern(Set<Character> separators) {
        String patternStr = separators.stream().map(Object::toString).collect(Collectors.joining());

        for (char i = '0'; i <= '9'; i++) {
            if (!separators.contains(i)) {
                patternStr += i;
            }
        }

        patternStr = "^[" + patternStr + "]*$";

        return Pattern.compile(patternStr);
    }
}
