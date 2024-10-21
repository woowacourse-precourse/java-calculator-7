package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 문자열 분리
        String input = Console.readLine();
        int sum = 0;
        String delimiter = ",|:";

        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        input = input.replace("\\n", "\n");

        if(input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n"); // \n 없으면 -1 출력됨
            if(delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
            // 커스텀 구분자
            delimiter = input.substring(2, delimiterIndex);
            // 커스텀 구분자 이후 숫자 문자열
            input = input.substring(delimiterIndex + 1);
        }

        String[] inputNumbers = input.split(delimiter);

        for(String number : inputNumbers) {
            number = number.trim();

            if(!isNumeric(number)) {
                throw new IllegalArgumentException("잘못된 입력입니다 : " + number);
            }

            int IntegerNum = Integer.parseInt(number);

            if(IntegerNum < 0) {
                throw new IllegalArgumentException("양수만 입력됩니다: " + number);
            }

            sum += IntegerNum;

        }

        System.out.println("결과 : " + sum);
    }

    // 숫자 여부 확인
    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
