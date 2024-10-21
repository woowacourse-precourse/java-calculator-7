package calculator;

import java.util.StringTokenizer;

public class Calculator {

    public static long addNumbers(String numbers, String separators) {
        StringTokenizer st = new StringTokenizer(numbers, separators);
        long answer = 0;
        while (st.hasMoreTokens()) {
            answer += Integer.parseInt(st.nextToken());
        }
        return answer;
    }

}
