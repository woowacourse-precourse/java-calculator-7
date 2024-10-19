package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력 받기
        String input = Console.readLine();
    }

    // 주어진 구분자를 사용해 문자열을 숫자로 분리하고 합을 구하는 메서드
    private int sum(String input, String delimiter) {
        String[] tokens = input.split(delimiter); // 구분자로 숫자 분리
        int result = 0;
        for (String token : tokens) {
            int number = toPositiveInt(token);
            result += number;
        }
        return result;
    }
}
