package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static final String regex = "//(.*?)\\\\n";
    static Set<String> separators = new HashSet<>(Arrays.asList(",", ":"));

    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void run() {
        String inputValue = input();
        boolean hasCustom = extractCustomSeparators(inputValue);
        if (hasCustom) {
            System.out.println(extractNumbersPart(inputValue));
        }
    }

    static boolean extractCustomSeparators(String input) {
        boolean flag = false;
        if (input == null) {
            System.out.println("빈문자열");
            return flag;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            flag = true;
            updateSeperator(matcher.group(1).trim());
        }
        return flag;
    }

    static void updateSeperator(String str) {
        separators.add(str);
    }

    static String extractNumbersPart(String input) {
        // 커스텀 구분자를 제거 한 문자열 출력
        return input.replaceAll(regex, "").trim();
    }
}
