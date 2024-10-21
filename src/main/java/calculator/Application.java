package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = application.calculate(input);
        System.out.println("결과 : " + result);
    }

    public int calculate(String text) {
        String defaultSeparator = findSeparator(text);
        text = text.replace("//"+defaultSeparator+"\\n", "");
        String[] textArray = replaceSeparator(text, defaultSeparator).split(defaultSeparator);
        int sum = 0;
        for (String str : textArray) {
            int num = parseInt(str);
            if(num < 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        return sum;
    }

    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private String findSeparator(String text) {
        int startIndex = text.indexOf("//") + 2;
        int endIndex = text.indexOf("\\n");
        if (startIndex != -1 && endIndex != -1) {
            return text.substring(startIndex, endIndex);
        }
        return ":";
    }

    private String replaceSeparator(String text, String separator) {
        return text.replaceAll("[:,]", separator);
    }

}
