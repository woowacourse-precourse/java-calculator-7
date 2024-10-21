package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);

        boolean isMatched = matcher.find();
        String delimiter = "[,:" + (isMatched ? matcher.group(1) : "") + "]";
        String numbers = isMatched ? matcher.group(2) : input;

        System.out.println("결과 : " +
            Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum));
    }
}
