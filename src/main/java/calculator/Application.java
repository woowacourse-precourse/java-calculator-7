package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: JAVA 21 에서 테스트
        String input = Console.readLine();
        add(input);
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

        // 이스케이프 문자 '\\n'을 '\n'으로 변환
        input = input.replace("\\n", "\n");

        // 커스텀 구분자 (문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용)
        if (input.startsWith("//")) {

            int endIndex = input.indexOf("\n");

            if (endIndex == -1) { // \n 을 입력하지 않았을 경우 예외처리
                throw new IllegalArgumentException("\\n을 입력하세요");
            }
            seperator = input.substring(2, endIndex); // 커스텀 구분자
            input = input.substring(endIndex + 1);

        }

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

        System.out.println(String.format("seperator: %s", seperator));
        System.out.println(String.format("입력 : %s", input));
        System.out.println(String.format("결과 : %s", sum));

        return "결과 : " + sum;
    }
}
