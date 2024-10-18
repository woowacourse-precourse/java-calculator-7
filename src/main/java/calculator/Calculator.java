package calculator;

import calculator.view.InputView;
import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
    }

    protected void start() {
        String input = InputView.input();

        String[] results = getNumberLists(input);

        int answer = getAnswer(results);
        System.out.println("answer = " + answer);
    }

    private String[] getNumberLists(String str) {
        // TODO: 구분자 커스텀 문자열이 없을 경우 (// or \n)
        if (str.charAt(0) == '/') {
            String delimiter = str.substring(2, str.indexOf("\\n"));
            System.out.println("delimiter = " + delimiter);
            String newStr = str.substring(str.indexOf("\\n") + 2);
            System.out.println("newStr = " + newStr);
            return newStr.split(Pattern.quote(delimiter) + "|[,:]");
        }
        return str.split("[,:]");
    }

    private static int getAnswer(String[] results) {
        int answer = 0;
        try {
            for (String result : results) {
                int number = Integer.parseInt(result);
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
