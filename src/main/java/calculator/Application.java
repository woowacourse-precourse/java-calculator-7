package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        ArrayList<Character> sep = new ArrayList<>();
        sep.add(':');
        sep.add(',');

        String input = Console.readLine();

        if (input.startsWith("//")) {
            sep.clear();

            int index = 2;

            while (!(input.charAt(index) == '\\' && input.charAt(index + 1) == 'n')) {
                index++;
            }

            for (int i = 2; i < index; i++) {
                sep.add(input.charAt(i));
            }

            if (sep.size() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 하나여야 합니다.");
            }

            input = input.substring(index + 2);
        }

        StringBuilder regex = new StringBuilder();
        for (char c : sep) {
            if (!regex.isEmpty()) {
                regex.append("|");
            }
            regex.append("\\").append(c);
        }

        String[] nums = input.split(regex.toString());

    }
}
