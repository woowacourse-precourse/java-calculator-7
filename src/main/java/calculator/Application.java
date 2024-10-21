package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String customDelimiter = getCustomDelimiter(input);
        if (customDelimiter != null) {
            String delimiterRemovedInput = input.substring(customDelimiter.length() + 5);
            String[] splitInput = delimiterRemovedInput.split(customDelimiter + "|" + "," + "|" + ":");
        } else {
            String[] splitInput = input.split("[,:]");
        }
    }

    public static String getCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            if (input.contains("\\n")) {
                return input.substring(input.indexOf("//") + 2, input.indexOf("\\n") - 1);
            }
            throw new IllegalArgumentException();
        }
        return null;
    }
}
