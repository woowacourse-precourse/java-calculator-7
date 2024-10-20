package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.StringTokenizer;

public class StringTokenizerSplitTest {
    String[] dividers = new String[] {"//", "\\n", ";", "divider", "구분자"};
    String[] tokens = new String[dividers.length];
    StringBuilder tokenResult = new StringBuilder();
    StringBuilder result = new StringBuilder();

    @BeforeEach
    void setTokens() {
        for (int i = 0; i < dividers.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 50; j++) {
                sb.append("abc").append(dividers[i]);
            }

            tokens[i] = sb.toString().trim();

            tokenResult.append("token: " + tokens[i] + "\n");
        }
    }

    @Test
    void stringTokenizer_split_속도비교() {
        for (int i = 0; i < dividers.length; i++) {
            String divider = dividers[i];
            String token = tokens[i];

            loopStringTokenizer(divider, token);
            loopSplit(divider, token);

            result.append("\n");
        }

        System.out.println(result.toString().trim());
    }

    void loopStringTokenizer(String divider, String token) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            StringTokenizer st = new StringTokenizer(token, divider);

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
            }
        }

        long endTime = System.currentTimeMillis();

        result.append("StringTokenizer " + divider + " 결과\n")
                .append(String.format("\t1000000번 분리하는데 걸린 시간: %d ms\n", endTime - startTime));
    }

    void loopSplit(String divider, String token) {
        // split은 \\를 이스케이프 문자로 인식하기 때문에 \\\\로 변경
        if (divider.equals("\\n")) {
            divider = "\\\\n";
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            String[] split = token.split(divider);

            for (String s : split) {
            }
        }

        long endTime = System.currentTimeMillis();

        result.append("split() " + divider + " 결과\n")
                .append(String.format("\t1000000번 분리하는데 걸린 시간: %d ms\n", endTime - startTime));
    }
}
