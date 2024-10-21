package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해주세요.");
        String input = readLine().trim();

        try {
            input = input.replace("\\n", "\n");
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 입력 형식 검증 추가
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 기본 구분자 설정
        List<String> delimiters = new ArrayList<>();
        delimiters.add(Pattern.quote(","));
        delimiters.add(Pattern.quote(":"));
        delimiters.add(Pattern.quote("|"));
        delimiters.add(Pattern.quote(";"));
        delimiters.add(Pattern.quote("*"));
        delimiters.add(Pattern.quote("/"));
        delimiters.add(Pattern.quote("-"));
        delimiters.add(Pattern.quote("+"));
        delimiters.add(Pattern.quote("%"));
        delimiters.add(Pattern.quote("^"));
        delimiters.add(Pattern.quote("("));
        delimiters.add(Pattern.quote(")"));
        delimiters.add(Pattern.quote("["));
        delimiters.add(Pattern.quote("]"));
        delimiters.add(Pattern.quote("{"));
        delimiters.add(Pattern.quote("}"));


        if (input.startsWith("//")) {
            if (input.startsWith("//[")) {
                // 여러 개의 커스텀 구분자 처리
                Matcher m = Pattern.compile("//(\\[.*?]+)\n" +
                        "(.*)", Pattern.DOTALL).matcher(input);
                if (m.find()) {
                    String delimitersPart = m.group(1);
                    input = m.group(2);

                    Matcher delimMatcher = Pattern.compile("\\[(.*?)]").matcher(delimitersPart);
                    while (delimMatcher.find()) {
                        delimiters.add(Pattern.quote(delimMatcher.group(1)));
                    }
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            } else {
                // 단일 문자 커스텀 구분자 처리
                Matcher matcher = Pattern.compile("//(.)\n(.*)", Pattern.DOTALL).matcher(input);
                if (matcher.find()) {
                    String customDelimiter = Pattern.quote(matcher.group(1));
                    delimiters.add(customDelimiter);
                    input = matcher.group(2);
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
        }

        return sum(input, delimiters);
    }

    private static int sum(String numbers, List<String> delimiters) {
        // 구분자 패턴 생성
        String delimiterPattern = String.join("|", delimiters);
        String[] tokens = numbers.split(delimiterPattern);
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) { // 빈 문자열은 무시
                try {
                    sum += Integer.parseInt(token);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + token);
                }
            }
        }

        return sum;
    }

    private static boolean isValidInput(String input) {
        // 입력 문자열이 허용된 형식인지 검증
        // 허용된 문자: 숫자, 구분자, 커스텀 구분자 선언 형식
        String pattern = "(//(\\[.*?]|.)\n" +
                ")?[0-9" + Pattern.quote(",:|;") + "\\[\\]\n]*";
        return input.matches(pattern);
    }
}