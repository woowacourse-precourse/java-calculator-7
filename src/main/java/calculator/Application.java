package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();

        if(input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        String delimiter = ",|:";  // 기본 구분자 설정
        String[] nums = input.split(delimiter);

        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }

        System.out.println("결과 : " + result);
    }
}
