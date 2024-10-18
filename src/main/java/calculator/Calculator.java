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
        for (String result : results) {
            answer += Integer.parseInt(result);
        }
        return answer;
    }



}
