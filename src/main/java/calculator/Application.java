package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String pattern = "^//.+\\\\n.*";
        StringTokenizer st = null;
        BigInteger result = BigInteger.ZERO;

        try {
            if (input.matches(pattern)) {
                String delim = input.substring(2, input.indexOf("\\n"));
                st = new StringTokenizer(input.substring(input.indexOf("\\n") + 2), delim);
            } else {
                st = new StringTokenizer(input, ",:");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input");
        }

        while (st.hasMoreTokens()) {
            BigInteger value = new BigInteger(st.nextToken());

            if (value.signum() < 0) {
                throw new IllegalArgumentException("Invalid input");
            }

            result = result.add(value);
        }

        System.out.println("결과 : " + result);
    }
}
