package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 1. 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputText = Console.readLine();

        // 2. 연산 과정
        String separator = ",|:";
        String[] tokens = inputText.split(separator);

        int sum = 0;

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                System.out.println("양수만 입력해 주세요.");
            }
            sum += number;
        }

        // 3. 출력
        System.out.println("결과 : " + sum);
    }
}
