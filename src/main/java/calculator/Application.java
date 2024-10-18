package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        int sum = 0;
        Set<Character> set = new HashSet<>();
        set.add(':');
        set.add(',');
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                tmp.append(c);
            }
            else if (set.contains(c)) {
                if (tmp.length() > 0) {
                    sum += Integer.parseInt(tmp.toString());
                    tmp.setLength(0);
                }
            }
        }
        if (tmp.length() > 0) {
            sum += Integer.parseInt(tmp.toString());
        }
        System.out.println("결과 : " + sum);
    }
}
