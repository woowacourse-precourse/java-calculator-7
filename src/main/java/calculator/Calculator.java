package calculator;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Calculator {
    private Set<String> delimiters;

    public Calculator(Set<String> delimiters) {
        this.delimiters = delimiters;
    }

    public int addition(String s) {
        if (s.startsWith("//")) {
            s = s.substring(4);
        }
        StringTokenizer st = new StringTokenizer(s, delimiters.stream().collect(Collectors.joining()));
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.valueOf(st.nextToken());
        }
        return sum;
    }
}
