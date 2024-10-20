package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separator {
    private final Delimiter delimiter;
    private final List<String> numList;

    public Separator(Delimiter delimiter) {
        this.delimiter = delimiter;
        numList = new ArrayList<>();
    }

    // 문자열 분리
    public List<String> separateString(String input) {
        List<String> delimiterList = delimiter.getDelimiters(input);

        if(delimiterList.size() == 3) {
            input = input.substring(5);
        }

        StringTokenizer st = new StringTokenizer(input);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String separatedStr = st.nextToken();

            try {
                int num = Integer.parseInt(separatedStr);
                sb.append(num);
            } catch(NumberFormatException e) {
                checkDelimiter(separatedStr, delimiterList);

                if(!sb.isEmpty()) {
                    numList.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        return numList;
    }

    // 해당 문자가 구분자인지 확인. 구분자가 아닌 문자열이 존재하면 예외 발생
    private void checkDelimiter(String separatedStr, List<String> delimiterList) {
        if(!delimiterList.contains(separatedStr)) {
            throw new IllegalArgumentException(
                "구분자가 아닌 문자열이 존재합니다. 지정된 구분자만 사용할 수 있습니다."
            );
        }
    }
}
