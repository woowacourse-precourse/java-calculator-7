package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static char[] basicSeparators = {',', ':'};
    private static char[] customSeparators = {'\0'};
    private static String userInput;

    // 문자열 덧셈 계산기 시작 함수
    public static void init() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    // 문자열 입력받는 함수
    public static void input() {
        userInput = Console.readLine();
    }

    // 커스텀 구분자 지정하는 함수
    public static void customSeparator(String input) {
        // "//"와 "\n" 사이에 문자가 존재하면 커스텀 구분자로 지정
        if(input.startsWith("//")) {
            if(input.substring(3, 5).equals("\\n")) {
                userInput = input.substring(5);
                customSeparators = new char[]{input.charAt(2)};
            }
        }
    }

    // 빈 문자열인지 확인하는 함수
    public static boolean validateInput(String input) {
        return input == null || input.isEmpty();
    }

    // 구분자(쉼표 or 콜론)을 올바르게 사용했는지 확인하는 함수
    public static void validateBasicSeparator(String input) {
        // 처음에 숫자가 나왔는지 확인
        if(!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("숫자부터 입력해야 합니다.");
        }

        // 기본 구분자인지 확인
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                char separator = input.charAt(i);

                if (!(separator == basicSeparators[0] || separator == basicSeparators[1])) {
                    throw new IllegalArgumentException("올바르지 않은 구분자를 사용하였습니다.");
                }
            }
        }

        // 숫자 사이에 하나의 구분자만 있는지 확인
        String[] st = input.split("[" + basicSeparators[0] + basicSeparators[1] + customSeparators[0] + "]");
        for(String s : st) {
            if(s == null || s.isEmpty()) {
                throw new IllegalArgumentException("구분자가 연속이거나 숫자 사이에 존재하지 않습니다.");
            }
        }
    }

    public static void main(String[] args) {
        init();
        input();
        customSeparator(userInput);
        if(validateInput(userInput)) {
            System.out.println("결과 : " + 0);
            return;
        };
        validateBasicSeparator(userInput);
    }
}
