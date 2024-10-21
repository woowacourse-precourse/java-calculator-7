package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 값 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static int add(String input) {
        // 입력값이 없는 경우
        if (input.isEmpty()) {
            return 0;
        }

        // 기본 구분자 지정
        String delimiter = "[,:]";

        // 커스텀 구분자 확인 하기
        if (input.startsWith("//")) {
            // \\의 index 확인 후, 커스텀 구분자 추출
            int newlineIndex = input.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalStateException("잘못된 형식입니다. 커스텀 구분자는 //와 \n 사이에 있어야 합니다.");
            }

            delimiter = input.substring(2, newlineIndex);
            if (delimiter.matches(".*[?*+()\\[\\]{}].*")) {
                delimiter = delimiter.replaceAll("([?*+()\\[\\]{}])", "\\\\$1");
            }
            input = input.substring(newlineIndex + 2);
        }

        // 입력값 나누기
        String[] numbers = input.split(delimiter);

        // 분리된 String을 int로 변환 후 더하기
        int sum = 0;
        for (String number: numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

}
