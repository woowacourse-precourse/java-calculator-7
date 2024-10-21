package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separator {
    private final Delimiter delimiter;
    private final List<BigInteger> numList;

    public Separator(Delimiter delimiter) {
        this.delimiter = delimiter;
        numList = new ArrayList<>();
    }

    // 문자열 분리
    public List<BigInteger> separateString(String input) {
        List<String> delimiterList = delimiter.getDelimiters(input);

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            input = input.substring(delimiterEndIndex + 2);
        }

        StringBuilder delimiterString = new StringBuilder();
        for (String delim : delimiterList) {
            delimiterString.append(delim);
        }

        StringTokenizer st = new StringTokenizer(input, delimiterString.toString());
        while(st.hasMoreTokens()) {
            String separatedStr = st.nextToken();

            try {
                BigInteger num = new BigInteger(separatedStr);
                numList.add(num);
            } catch (NumberFormatException e) {
                // 숫자 변환 실패 시 예외 발생 후 프로그램 종료
                throw new IllegalArgumentException(
                        "잘못된 입력입니다. 입력 문자열에는 숫자만 포함되어야 합니다: " + separatedStr
                );
            }
        }

        return numList;
    }
}
