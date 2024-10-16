package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInputNumber = input.split(",|:");
        int result = 0;
        for (String number : splitInputNumber) {
            result += Integer.parseInt(number);
        }
        System.out.println(result);
    }
}
