package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String pattern = "^//.\\\\n.*";
        StringTokenizer st = null;
        int result = 0;

        if (input.matches(pattern)) {
            String delim = String.valueOf(input.charAt(2));
            st = new StringTokenizer(input.substring(5), delim);
        } else {
            st = new StringTokenizer(input, ",:");
        }

        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());

            if (value < 0) {
                throw new IllegalArgumentException();
            }

            result += value;
        }

        System.out.println("결과 : " + result);
    }
}
