package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

        String input = Console.readLine();

        if (input.startsWith("//")) {
            // //@\n1@2,3:4
            int customDelimiterEndIndex = input.indexOf("\\n");
        }


    }
}