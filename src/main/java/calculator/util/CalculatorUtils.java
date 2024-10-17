package calculator.util;

import java.util.Scanner;
import java.util.Set;

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
        // 커스텀 구분자가 없는 경우 return
        if (userInput.length() < 2 || userInput.charAt(0) != '/' || userInput.charAt(1) != '/') {
            return;
        }
        for (int i = 2; i < userInput.length(); i++) {
            char ch = userInput.charAt(i);
            // 커스텀 구분자 부분이 끝난 경우 return
            if (ch == '\n') {
                return;
            }
            // 커스텀 구분자가 끝나기 전에 숫자가 나오면 잘못된 입력으로 처리
            if (ch >= '0' && ch <= '9') {
                throw new IllegalArgumentException("사용자 입력이 올바르지 않습니다.");
            }
            // 커스텀 구분자 separators에 추가
            separators.add(ch);
        }
    }
}
