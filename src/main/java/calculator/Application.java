package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        List<Integer> nums = StringParser.intListWithoutSeparator(input);

        for(Integer num : nums)
            System.out.println(num);
    }
}
