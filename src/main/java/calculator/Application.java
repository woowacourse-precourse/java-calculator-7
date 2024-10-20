package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static String[] basicSeparators = {",", "\\n"};
    private static char[] customSeparators;

    // 문자열 덧셈 계산기 시작 함수
    public static void init() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    // 문자열 입력받는 함수
    public static void input() {
       String input = Console.readLine();
    }

    // 커스텀 구분자 지정하는 함수
    public static void customSeparator(String input) {
        // "//"와 "\n" 사이에 문자가 존재하면 커스텀 구분자로 지정
        if(input.startsWith("//")) {
            if(input.substring(3, 5).equals("\\n")) {
                customSeparators = new char[]{input.charAt(2)};
            }
        }
    }

    public static void main(String[] args) {
        init();
        input();
    }
}
