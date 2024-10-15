package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public List<Character> extractCustomSeparator(String input) {
        String[] separatorParts = input.split("//");
        List<Character> customSeparators = new ArrayList<>();

        if (separatorParts.length < 2) {
            return customSeparators;
        }

        for (int i = 1; i < separatorParts.length; i++) {
            if (separatorParts[i].contains("\n")) {
                String[] tmp = separatorParts[i].split("\n", 2);
                String separator = tmp[0];

                if (separator.length() != 1) {
                    throw new IllegalArgumentException("구분자는 반드시 하나의 문자여야 합니다.");
                }

                if (!separator.isEmpty()) {
                    customSeparators.add(separator.charAt(0));
                } else {
                    throw new IllegalArgumentException("잘못된 커스텀 구분자입니다.");
                }
            }
        }
        return customSeparators;
    }


    public int calculateSum(String input) {
        List<Character> customSeparators = extractCustomSeparator(input);
        return 0;
    }

    public static void main(String[] args) {
        Application T = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int sum = T.calculateSum(input);
        System.out.println("결과 : " + sum);
    }
}
