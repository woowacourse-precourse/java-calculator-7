package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Application {

    private static final int SEPARATOR_START = 2;

    public static void main(String[] args) {
        String input = readIn(); // 입력
        Set<String> separatorSet = parseSeparator(input);
        String afterSeparator = input.substring(findSeparatorEndIndex(input));
        System.out.println("Separators: " + separatorSet);
        System.out.println("After separator: " + afterSeparator);
    }

    public static String readIn() {
        String newInput = Console.readLine();
        if (newInput == null || newInput.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        return newInput;
    }


    public static Set<String> parseSeparator(String input) {
        Set<String> separatorSet = new HashSet<>();

        if (input.startsWith("//")) {
            for (int i = SEPARATOR_START; i < input.length(); i++) {
                if (input.charAt(i) == '\\') {
                    if (i < input.length() - 1 && input.charAt(i + 1) == 'n') {
                        break;
                    }
                } else {
                    separatorSet.add(input.substring(i, i + 1));
                }
            }
        }

        separatorSet.add(",");
        separatorSet.add(":");
        return separatorSet;
    }

    // 구분자 끝을 찾는 로직
    private static int findSeparatorEndIndex(String input) {
        return 0;
    }
}

