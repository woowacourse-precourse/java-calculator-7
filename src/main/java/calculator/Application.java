package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = getInput();
        if (isCustomSeparatorExist(input)) {
            String customSeparator = getCustomSeparator(input);
        }
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static boolean isCustomSeparatorExist(String given) {
        return given.startsWith("//") && given.charAt(3) == '\n';
    }

    public static String getCustomSeparator(String given) {
        return given.substring(2, 3);
    }

}
