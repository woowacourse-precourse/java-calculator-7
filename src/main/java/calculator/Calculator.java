package calculator;

import java.util.StringTokenizer;

public class Calculator {
    public long sum(StringTokenizer st) {

        long sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }
}
