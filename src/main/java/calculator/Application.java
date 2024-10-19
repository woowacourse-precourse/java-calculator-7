package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    static String patternRule = "//(.)\\\\n(.*)";
    static String delimiter = ",|:";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.startsWith("//")) {
            String customDelimiter = extractCustomDelimiter(input);
            input = extractSentence(input);
            delimiter = delimiter + "|" + Pattern.quote(customDelimiter);
        }
        String[] tokens = input.split(delimiter);
        int result = calculateSentence(input);
        System.out.println("결과 : " + result);
    }
    public static String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            if (customDelimiter.matches("[a-zA-Z0-9]")) {
                throw new IllegalArgumentException();
            }
            return customDelimiter;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public static String extractSentence(String input) {
        Pattern pattern = Pattern.compile(patternRule);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher.group(2);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public static int calculateSentence(String input) {
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            if(!token.isEmpty()) {
                try {
                    int num = Integer.parseInt(token);
                    if (num < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return sum;

    }



}
