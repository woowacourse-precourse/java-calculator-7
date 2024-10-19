package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    static List<String> separator = Arrays.asList(",", ":");
    public static void main(String[] args) {
        try {
            String userInput = Console.readLine();
            addSeparator(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addSeparator(String userInput) {
        if (userInput.startsWith("//.*\n")) {
            String nsep = userInput.substring(2, userInput.indexOf(10));
            if (nsep.matches(".*[0-9].*")) {
                throw new IllegalArgumentException("오류: 구분자에 숫자가 포함되어 있습니다.");
            }
            separator.add(nsep);
        }
    }


}
