package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static String cutomSeparatorStart = "//";
    static String cutomSeparatorEnd = "\\n";
    static String or = "|";
    static String numberRegex = "\\d+"; // s.matches(numberRegex)
    static String defaultSeparatorRegex = ",|:";

    public static void main(String[] args) {
        StringBuilder separatorRegex = new StringBuilder(defaultSeparatorRegex);
        String input = Console.readLine();

        if (!input.isEmpty() && input.substring(0, 2).equals(cutomSeparatorStart)) {
            if (input.contains(cutomSeparatorEnd)) {
                String customDelim = input.substring(2, input.indexOf(cutomSeparatorEnd));
                separatorRegex.append(or).append(customDelim);
            } else {
                throw new IllegalArgumentException("\n지정 구분자는 //와 \\n 사이에 입력해주세요");
            }
            input = input.substring(input.indexOf(cutomSeparatorEnd) + cutomSeparatorEnd.length());
        }

        List<String> strs = Arrays.stream(input.split(separatorRegex.toString())).toList();

        System.out.println(strs);

        int sum = strs.stream()
                .filter(s -> !s.isEmpty())
                .map(s -> {
                    if (!s.matches(numberRegex))
                        throw new IllegalArgumentException(s + " 는 허용되지 않는 문자입니다");
                    return Integer.parseInt(s);
                })
                .reduce(0, Integer::sum);

        System.out.printf("결과 : %d\n", sum);
    }
}
