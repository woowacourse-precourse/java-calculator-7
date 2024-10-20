package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Character> inputList = new ArrayList<>();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        int sum = 0;

        if (input.isEmpty()) {
            System.out.println("결과 : " + sum);
            Console.close();
            return;
        }
        for (char c : input.toCharArray()) {
            inputList.add(c);
        }
    }
}
