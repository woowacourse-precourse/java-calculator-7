package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separator {
    private final Delimiter delimiter;
    private final List<Integer> numList;

    public Separator(Delimiter delimiter) {
        this.delimiter = delimiter;
        numList = new ArrayList<>();
    }

    // 문자열 분리
    public List<Integer> separateString(String input) {
        List<String> delimiterList = delimiter.getDelimiters(input);

        if(delimiterList.size() == 3) {
            input = input.substring(5);
        }

        StringBuilder delimiterString = new StringBuilder();
        for (String delim : delimiterList) {
            delimiterString.append(delim);
        }

        StringTokenizer st = new StringTokenizer(input, delimiterString.toString());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String separatedStr = st.nextToken();

            try {
                int num = Integer.parseInt(separatedStr);
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

    // 해당 문자가 구분자인지 확인. 구분자가 아닌 문자열이 존재하면 예외 발생
    private void checkDelimiter(String separatedStr, List<String> delimiterList) {
        if(!delimiterList.contains(separatedStr)) {
            throw new IllegalArgumentException(
                "구분자가 아닌 문자열이 존재합니다. 지정된 구분자만 사용할 수 있습니다."
            );
        }
    }
}
