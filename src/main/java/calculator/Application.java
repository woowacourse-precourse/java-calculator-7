package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String[] numbers = Console.readLine().split("[,:]+");

        int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();

        System.out.println("결과 : " + sum);
    }
}
