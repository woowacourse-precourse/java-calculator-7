package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    /**
     * 커스텀 구분자 처리를 위한 이스케이프 문자와 특수문자를 담은 문자열
     */
    static final String SPECIAL_LETTERS = "+-*/%=><'\"\\";
    static String identifier = ",|:"; // 구분자를 모아놓은 문자열

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        int result = process(str);
        System.out.println("결과 : " + result);
    }

    public static int process(String str) {
        int result = 0;

        if (str.isEmpty()) {
            return result;
        }

        str = customIdentifierProcess(str); // 커스텀 구분자 처리
        return extractNumbers(str); // 계산된 값을 반환
    }

    public static String customIdentifierProcess(String str) {
        if (str.startsWith("//")) {
            int lastIndex = str.indexOf("\\n");
            invalidCustomIdentifierCheck(lastIndex);
            addCustomIdentifier(str.substring(2, lastIndex));
            str = str.substring(lastIndex + 2); // 커스텀 구분자 문자열을 삭제
        }
        return str;
    }

    public static void invalidCustomIdentifierCheck(int lastIndex) {
        if (lastIndex == -1) {
            throw new IllegalArgumentException();
        }
    }

    public static void addCustomIdentifier(String custom) {
        for (char c : custom.toCharArray()) {
            if (SPECIAL_LETTERS.contains(c + "")) {
                identifier += "|\\" + c; // 특수문자는 이스케이프 처리
            } else {
                identifier += "|" + c; // 일반문자는 그대로 추가
            }
        }
    }

    public static int extractNumbers(String str) {
        return getResult(str.split(identifier));
    }

    public static int getResult(String[] numbers) {
        int result = 0;
        for (String s : numbers) {
            int num = Integer.parseInt(s);
            negativeCheck(num);
            result += num;
        }
        return result;
    }

    public static void negativeCheck(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
