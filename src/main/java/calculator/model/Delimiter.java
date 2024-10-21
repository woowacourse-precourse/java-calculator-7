package calculator.model;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private Set<String> delimiters;

    public Delimiter() {
        delimiters = new HashSet<>();
        // 기본 구분자 추가 (쉼표, 콜론)
        delimiters.add(",");
        delimiters.add(":");
    }

    // 커스텀 구분자를 추가하는 메서드
    public void addCustomDelimiter(String customDelimiter) {
        delimiters.add(customDelimiter);
    }

    // 커스텀 구분자가 있는지 확인하고 추가하는 메서드
    public String processCustomDelimiter(String input) {
        System.out.println(input);
        if (input.startsWith("//")) {
            String[] parts = input.split("\\n");
            System.out.println("part0" + parts[0]);
            System.out.println("part1" + parts[1]);

            if (parts.length == 2) {
                //addCustomDelimiter(String.valueOf(parts[0].charAt(2)));
                String customDelimiter = parts[0].substring(2);
                addCustomDelimiter(customDelimiter);
                return parts[1];
            }
        }
        return input;
    }

    // 현재 구분자를 기준으로 문자열을 나누는 메서드
    public String[] split(String input) {
        input = processCustomDelimiter(input);
        String delimiterRegex = String.join("|", delimiters);
        return input.split(delimiterRegex);
    }
}
