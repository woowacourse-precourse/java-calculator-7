package calculator;

import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
    }

    protected void start(String input) {
        String[] results = getNumberLists(input);

        int answer = getSum(results);
        System.out.println("결과 : " + answer);
    }

    public String[] getNumberLists(String str) {
        if (str.startsWith("//")) {
            int delimiterIndex = str.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 설정이 잘못 되었습니다.");
            }
            String delimiter = str.substring(2, delimiterIndex);
            String newStr = str.substring(delimiterIndex + 2);

            return newStr.split("[" + Pattern.quote(delimiter) + ",:]+");
        }
        return str.split("[,:]+");
    }

    public int getSum(String[] results) {
        int answer = 0;
        try {
            for (String result : results) {
                if (result.isEmpty()) {
                    continue;
                }
                int number = Integer.parseInt(result.strip());
                if (number <= 0) {
                    throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
                }
                answer += number;

            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자만 입력이 가능합니다.");
        }

        return answer;
    }
}
