package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 1. 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputText = Console.readLine();

        // 2. 연산 과정
        String separator = ",|:";

        // 2-1. 커스텀 구분자가 있을 경우
        if (inputText.startsWith("//")) {
            int separatorIndex = inputText.indexOf("\\n");
            if (separatorIndex == -1) { // "\n"이 없는 경우 [오류]
                System.out.println("잘못된 입력 값 입니다.");
            }

            separator = inputText.substring(2, separatorIndex);
            inputText = inputText.substring(separatorIndex + 2);
        }

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
