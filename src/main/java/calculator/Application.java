package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String input = Console.readLine();
        try {
        splitAndSum(input);
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage()); // 예외 발생 시 메시지 출력
    }
}

    public static void splitAndSum(String input) {
        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }
        String delimiter = ",|:";


        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex > 2) {
                String customDelimiter = input.substring(2, newlineIndex);
                if (customDelimiter.length() == 1) {
                    delimiter = customDelimiter;
                    input = input.substring(newlineIndex + 2);
                } else {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다. 구분자는 한 개만 허용됩니다.");
                }
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. '\\n'이 필요합니다.");
            }
        }

        String[] strArr = input.split(delimiter);
        int sum = 0;
        for (String str : strArr) {
            sum += Integer.parseInt(str);
        }
        System.out.println("결과: " + sum);
    }


}
