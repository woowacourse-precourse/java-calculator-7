package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            String[] splitStr = input.split("\n",2);
            delimiter = splitStr[0].substring(2); // 커스텀 구분자 추출
            numbers = splitStr[1];
        }

        // 숫자를 구분자를 기준으로 분리
        String[] tokens = numbers.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += number;
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}
