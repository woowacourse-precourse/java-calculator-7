package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    // 음수를 체크하고, 예외를 던지는 메서드
    private static int toPositiveInt(String number) {
        int num = Integer.parseInt(number);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
        }
        return num;
    }

    // 주어진 입력 문자열을 처리
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            // "//" 뒤에 오는 구분자를 추출하고, \n로 구분
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);  // 커스텀 구분자 추출
            input = input.substring(delimiterIndex + 2);     // 숫자 부분 추출
        }
        // 입력을 구분자로 분리하여 계산
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += toPositiveInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
            }
        }
        return sum;
    }
}
