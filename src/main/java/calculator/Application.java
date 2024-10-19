package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        // 1) 문자열 입력 및 처리
        String input = Console.readLine();

        System.out.println("결과 : " + calculator(input));

    }

    public static int calculator(String input) {
        // 1.1) 입력 문자열이 비어있을 경우 0을 출력
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);

        // 3) 문자열에서 숫자 추출 후 더하기
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    // 2) 구분자를 기준으로 문자열 분리
    private static String[] splitInput(String input) {
        String delimiter = ",|:"; // 기본 구분자

        // 4) 커스텀 구분자 지정
        if (input.startsWith("//")) {
            int delimiterIndex = input.lastIndexOf("\\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex); // 커스텀 구분자 추출
                input = input.substring(delimiterIndex + 2); // 실제 숫자 부분
            }
        }

        return input.split(delimiter);
    }

}
