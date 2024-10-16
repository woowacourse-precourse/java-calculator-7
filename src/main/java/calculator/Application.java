package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

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
            delimiterRegex = String.format("(%s|%s)", delimiterRegex, String.join("|", customDelimiters));
            inputText = inputText.replaceAll(customDelimiterRegex, "");
        }

        String expressionRegex = String.format("^(%s)*(([0-9]+)%s)*[0-9]+$", customDelimiterRegex, delimiterRegex);
        if (!inputText.matches(expressionRegex)) {
            throw new IllegalArgumentException("입력 값이 올바르지 않습니다.");
        }

        Integer sum = Arrays.stream(inputText.split(delimiterRegex))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(0);

        System.out.printf("결과 : %d\n", sum);

    }
}
