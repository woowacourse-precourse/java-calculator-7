package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: JAVA 21 에서 테스트
        String input = Console.readLine();
        String result = add(input);
        System.out.println(result);
        Console.close();
    }

    public static String add(String input) {
        // 빈 문자열일 경우 0 반환
        if (input.isEmpty()) {
            return "결과 : 0";
        }

        // TODO : 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

        // 기본 구분자 (쉼표, 콜론)
        String seperator = ",|:";

        // 입력에서 구분자를 기준으로 숫자 추출
        String[] numbers = input.split(seperator);

        int sum = 0;
        for (String number : numbers) {

            // 음수 체크
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다");
                }
                sum += num;
            }
        }

        return "결과 : " + sum;
    }
}
