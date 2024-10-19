package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받기
        String input = Console.readLine();

        // 빈 문자열 또는 null 처리
        if (input == null || input.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        String delimiter = ",|:"; // 기본 구분자 (쉼표와 콜론)


        // 구분자를 사용해 문자열을 분리
        String[] input_integer = input.split(delimiter);
        int sum = 0;
        for (String integer : input_integer) {
            sum += Integer.parseInt(integer.trim()); // 각 문자열을 정수로 변환해 합산
        }

        // 결과 출력
        System.out.println("결과 : " + sum);
    }
}
