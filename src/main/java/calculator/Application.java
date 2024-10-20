package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        // 시작 문자가 숫자다 => 기본 구분자 사용
        // 시작 문자가 숫자가 아니다 => 커스텀 구분자 사용
        if (!input.isBlank()) {
            char start = input.charAt(0);
            if ('0' <= start && start <= '9') {
                String[] nums = input.split("[,:]");
                printNumberSum(nums);
            } else if (input.matches("^//.\\\\n.*")) {
                String spliter = String.valueOf(input.charAt(2));
                input = input.substring(5);
                String[] nums = input.split(spliter);
                printNumberSum(nums);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void printNumberSum(String[] nums) {
        int result = Stream.of(nums).map(Integer::parseInt).reduce(0, Integer::sum);
        System.out.println("결과 : " + result);
    }

}
