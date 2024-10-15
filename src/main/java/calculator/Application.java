package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputText = Console.readLine();

        String delimiterRegex = "[,:]";
        String customDelimiterRegex = "//(.*?)\\\\n";
        String[] customDelimiters = inputText
                .replaceAll(customDelimiterRegex, "$1 ")
                .split(" ");
        customDelimiters = Arrays.copyOfRange(customDelimiters, 0, customDelimiters.length - 1);

        if (customDelimiters.length > 0) {
            delimiterRegex = "(" + delimiterRegex + "|" + String.join("|", customDelimiters) + ")";
            inputText = inputText.replaceAll(customDelimiterRegex, "");
        }

        List<Integer> values = Arrays.stream(inputText.split(delimiterRegex))
                .map(Integer::parseInt).toList();
        Integer sum = 0;

        for (Integer value : values)
            sum += value;

        System.out.println(sum);
    }
}
