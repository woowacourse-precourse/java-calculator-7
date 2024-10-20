package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String input;
        String delimiter = ",:";
        String customDelimiter;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();

        // 빈 문자열 입력 예외 처리
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        // 커스텀 구분자 추출
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            //System.out.println(delimiterEndIndex);
            if (delimiterEndIndex >= 0) {
                customDelimiter = StringUtil.getCustomDelimiter(input, delimiterEndIndex);
                delimiter = delimiter + customDelimiter;
                //System.out.println(delimiter);
                input = input.substring(delimiterEndIndex + 2);  // 커스텀 구분자 지정 부분 제거
            }
        }

        // 숫자 분리
        ArrayList<Integer> numbers;
        numbers = StringUtil.split(input, delimiter);

        // 합 계산
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        System.out.println("결과 : " + sum);
    }
}
