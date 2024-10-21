package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String input;
    private String delimeter = ":|,";

    public void run() {
        getInput();

        String[] splitted = split();
        int result = add(splitted);

        System.out.println("결과 : " + result);
    } 

    private void getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.input = Console.readLine();

        String regex = "(?://(\\S)\\\\n)?[0-9]+(?:(?:\\:|,|\\1)[0-9]+)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        splitInputDelimeter();
    }

    private void splitInputDelimeter () {
        Pattern pattern = Pattern.compile("//(\\S)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            this.delimeter += "|" + matcher.group(1);
            this.input = matcher.replaceAll("");
        } 
    }

    private String[] split() {
        String[] splitted = input.split(delimeter);

        return splitted;
    }

    private int add(String[] splitted) {
        int total = 0;

        for (int i = 0; i < splitted.length; ++i) {
            total += Integer.parseInt(splitted[i]);
        }

        return total;
    }
}
