package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = readLine();

        String separators = getSeparator(inputStr);
        String numbers = inputStr;

        if (inputStr.startsWith("//")) {
            int newlineIndex = inputStr.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식: 커스텀 구분자는 \\n을 포함해야 합니다.");
            }
            numbers = inputStr.substring(newlineIndex + 2);
        }
    }

    public static String getSeparator(String inputStr) {
        /**
         * 1. "//"로 시작하면 "\n"이 반드시 등장해야 함
         * 2. "//"와 "\n" 사이에 문자가 '하나' 있어야 함
         * 3. 커스텀 구분자를 사용하면 해당 문자만 사용해야 함
         * 4. 커스텀 구분자가 없으면 기본 구분자인 ,: 만 사용할 수 있음
         */

        if (!inputStr.startsWith("//")) {
            validateInput(inputStr);
            return ",:";
        }

        int newlineIndex = inputStr.indexOf("\\n");
        if (newlineIndex == -1) {
            throw new IllegalArgumentException("잘못된 형식: 커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customSeparator = inputStr.substring(2, newlineIndex);
        if (customSeparator.length() != 1) {
            throw new IllegalArgumentException("잘못된 형식: 커스텀 구분자는 하나의 문자여야 합니다.");
        }

        return customSeparator;
    }

    private static void validateInput(String inputStr) {

        for (int i = 0; i < inputStr.length(); i++) {
            char value = inputStr.charAt(i);

            if (Character.isDigit(value)) {
                continue;
            }

            if (value != ',' && value != ':') {
                throw new IllegalArgumentException("잘못된 문자: " + value);
            }
        }
    }
}

