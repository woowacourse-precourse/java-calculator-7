package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        Set<String> delimiters = new HashSet<>();
        StringBuilder number = new StringBuilder();
        StringBuilder fixDelimiter = new StringBuilder();

        // 유효성 검사 - 문자열이 비어있는지 확인
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // 유효성 검사 - 커스텀 구분자가 있는지 확인
        if (input.startsWith("//") && input.contains("\\n")) {
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\\n");
            String customerDelimiter = input.substring(start, end);
            delimiters.add(customerDelimiter);
            input = input.replace("//" + customerDelimiter + "\\n", "");
        }

        // 유효성 검사 - 문자열 앞 뒤에 구분자가 있는지 확인
        if (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(input.length() - 1))) {
            throw new IllegalArgumentException();
        }

        // 문자열을 구분자, 정수 집합으로 분리
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            }
            else {
                fixDelimiter.append(c);
            }

            if (!number.isEmpty() && (!Character.isDigit(c) || i == input.length() - 1)) {
                numbers.add(Integer.parseInt(number.toString()));
                number.setLength(0);
            }
            if (!fixDelimiter.isEmpty() && Character.isDigit(c)){
                delimiters.add(fixDelimiter.toString());
                fixDelimiter.setLength(0);
            }
        }

        // 정해진 구분자인지 확인
        if (delimiters.size() > 1 && (!delimiters.contains(",") || !delimiters.contains(":"))) {
            throw new IllegalArgumentException();
        }

        int total = 0;
        for (int i : numbers) {
            total += i;
        }
        System.out.println("결과 : " + total);
    }
}
