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

        String delimiter = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자를 지정하기 위한 \\n가 누락되었습니다.");
            }

            String customDelimiter = input.substring(2, newlineIndex);
            delimiter = customDelimiter + "|" + delimiter;
            input = input.substring(newlineIndex + 2);  // 구분자 이후의 본문만 남김
        }

        String[] nums = input.split(delimiter);
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }

        System.out.println("결과 : " + result);
    }
}
