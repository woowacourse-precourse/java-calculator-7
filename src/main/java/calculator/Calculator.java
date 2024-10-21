package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    String delimiter = ",|:";

    public void run() {
        String input = getInput();

        input = addDelimiter(input);

        String[] delimitedInput = delimitString(input);
        int sumOfInput = sumOfList(delimitedInput);

        System.out.println("결과 : " + sumOfInput);
    }

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public String addDelimiter(String input) {

        Pattern pattern = Pattern.compile("//(\\S)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            this.delimiter += "|" + matcher.group(1);
            input = matcher.replaceFirst("");
        }
        return input;
    }

    public String[] delimitString(String input) {
        return input.split(delimiter);
    }

    public int sumOfList(String[] input) {
        int total = 0;
        for (String s : input) {
            total += Integer.parseInt(s);
        }
        return total;
    }
}
