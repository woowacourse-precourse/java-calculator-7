package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Application {

    private static final int SEPARATOR_START = 2;

    public static void main(String[] args) {
        String input = Console.readLine(); // 입력
        int endIndex = findSeparatorEndIndex(input);
        Set<String> separatorSet = parseSeparator(input,endIndex);
        String afterSeparator = input.substring(endIndex);
        System.out.println("Separators: " + separatorSet);
        System.out.println("After separator: " + afterSeparator);
    }


    public static Set<String> parseSeparator(String s, int endIndex) {

        Set<String> separatorSet = new HashSet<>();
        separatorSet.add(":");
        separatorSet.add(",");
        if(endIndex < 4) {
            return separatorSet;
        }
        for(char c : s.substring(2, endIndex-2).toCharArray()) {
            separatorSet.add(c + "");
        }
        return separatorSet;
    }

    // 구분자 끝을 찾는 로직
    private static int findSeparatorEndIndex(String input) {
        if (input.startsWith("//")) {
            for (int i = SEPARATOR_START; i < input.length(); i++) {
                if (input.charAt(i) == '\\') {
                    if (i < input.length() - 1 && input.charAt(i + 1) == 'n') {
                        return i+2<input.length() ? i+2 : input.length()-1;
                    }
                }
            }
        }
        return 0;
    }
}

