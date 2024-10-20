package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        List<Integer> nums = StringParser.intListWithoutSeparator(input);

        Integer sum = 0;
        for(Integer num : nums)
            sum += num;
        System.out.println("결과 : " + sum);
    }
}
