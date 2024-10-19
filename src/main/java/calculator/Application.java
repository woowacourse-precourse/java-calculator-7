package calculator;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ArrayList<String> numbers = new ArrayList<>();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        boolean isCustom = false;

        StringBuilder tempCustomString = new StringBuilder();
        String rest = input;

        for (int i = 0; i < input.length() - 1; i++) {
            if (!isCustom) {
                if (input.startsWith("//", i)) {
                    isCustom = true;
                    tempCustomString = new StringBuilder("//");
                }
            } else {
                if (input.startsWith("\\n", i)) {
                    isCustom = false;
                    tempCustomString.append(input, i, i + 2);
                    rest = rest.replace(tempCustomString, ":");
                } else {
                    tempCustomString.append(input.charAt(i));
                }
            }
        }

        if (isCustom) {
            throw new IllegalArgumentException("커스텀 구분자가 닫혀 있지 않습니다.");
        }
    }
}
