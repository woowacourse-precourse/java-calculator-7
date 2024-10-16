package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static String cutomSeparatorStart = "//";
    static String cutomSeparatorEnd = "\\n";
    static String or = "|";
    static String numberRegex = "-?\\d+"; // s.matches(numberRegex)

    public static void main(String[] args) {
        StringBuilder separatorRegex = new StringBuilder(",|:");
        String input = Console.readLine();

        if (!input.isEmpty() && input.substring(0, 2).equals(cutomSeparatorStart)) {
            if (input.contains(cutomSeparatorEnd)) {
                String customDelim = input.substring(2, input.indexOf(cutomSeparatorEnd));
                separatorRegex.append(or + customDelim);
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
                    try {
                        return Integer.parseInt(s);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(s + "는 허용되지 않는 문자입니다\n허용되는 문자: 숫자\n\t\t\t고정 구분자 , 와 :\n\t\t\t//와 \\n 사이에 지정 구분자");
                    }
                })
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
