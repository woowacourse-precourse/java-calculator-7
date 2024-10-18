package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        // 1) 문자열 입력 및 처리
        String input = Console.readLine();

    }

    public static int calculator(String input) {
        // 1.1) 입력 문자열이 비어있을 경우 0을 출력
        if (input.isEmpty()) {
            return 0;
        }

        // 2) 구분자를 기준으로 문자열 분리
        String delimiter = ",|:";

        String[] tokens = input.split(delimiter);

        // 3) 문자열에서 숫자 추출 후 더하기
        int sum = 0;

        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }

}
