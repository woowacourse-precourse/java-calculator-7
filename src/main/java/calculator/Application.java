package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String str = "";
        if (input.charAt(0) == '/') {
            try {
                str = checkCustomDelimiter(input);
                input = input.substring(5);
            } catch (Exception e) {
                throw e;
            }
        }

        StringTokenizer st;
        st = new StringTokenizer(input, ",:" + str);
        try {
            checkInput(st);
        } catch (Exception e) {
            throw e;
        }

        int sum = 0;
        st = new StringTokenizer(input, ",:" + str);
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println("결과 : " + sum);

    }

    private static String checkCustomDelimiter(String input) {
        if (input.length() > 4
                && input.charAt(1) == '/'
                && input.charAt(3) == '\\'
                && input.charAt(4) == 'n') {
            return String.valueOf(input.charAt(2));
        }
        throw new IllegalArgumentException("잘못된 입력입니다");
    }

    private static void checkInput(StringTokenizer st) {
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            try {
                int num = Integer.parseInt(s);
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 입력입니다");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다");
            }
        }
    }
}
