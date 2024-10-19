package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        String s = readIn();
        Set<String> separatorSet = parseSeparator(s);
        System.out.println("Separators: " + separatorSet);
    }

    public static String readIn() {
        String new_in = Console.readLine();
        if (new_in == null || new_in.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return new_in;
    }

    public static Set<String> parseSeparator(String input) {
        Set<String> separatorSet = new HashSet<>();

        if (input.startsWith("//")) {
            for (int i = 2; i < input.length(); i++) {
                if (input.charAt(i) == '\\') {
                    if (i < input.length() - 1) {
                        if(input.charAt(i+1) == 'n') break;
                        separatorSet.add(input.substring(i, i + 1));
                    }
                }
                else separatorSet.add(input.substring(i, i + 1));
            }
        }
        separatorSet.add(",");
        separatorSet.add(":");
        return separatorSet;
    }
}

