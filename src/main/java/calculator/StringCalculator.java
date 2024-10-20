package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String BASIC_SEPARATOR = ",|:";
    private final String CUSTOM_SEPARATOR_PATTERN = "//(.)\\\\n(.*)";
    private String customSeparator = "";


    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public boolean isNullOrEmpty(String userInput) {
        return userInput == null || userInput.isEmpty();
    }

    public boolean isInvalid(String userInput, String separator) {
        String regString = separator.replace("|", "");
        Pattern pattern = Pattern.compile("[^0-9" + regString + "]");

        return pattern.matcher(userInput).find();
    }

    public String filterCustomSeparatorPattern(String userInput) {
        // 1. Pattern 객체를 사용하여 문자열을 패턴 객체로 변환
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);

        // 2. 패턴 객체를 사용해 사용자 입력값을 검사하고 필터링된 결과를 Matcher 객체로 반환
        Matcher matcher = pattern.matcher(userInput);

        // 3. 매칭된 결과가 있는지 확인
        if (matcher.find()) {
            customSeparator = matcher.group(1);
            userInput = matcher.group(2);
        }

        return userInput;
    }

    public int splitAndSum(String userInput) {
        String separator = customSeparator.isEmpty() ? BASIC_SEPARATOR : BASIC_SEPARATOR + "|" + customSeparator;

        if (this.isInvalid(userInput, separator)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(userInput.split(separator))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}