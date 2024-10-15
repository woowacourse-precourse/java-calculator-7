package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

        String input = Console.readLine();

        if (input.startsWith("//")) {
            // //@\n1@2,3:4
            int customDelimiterEndIndex = input.indexOf("\\n");
            CustomDelimiter customDelimiter = new CustomDelimiter(input.substring(2, customDelimiterEndIndex));
            input = input.substring(customDelimiterEndIndex + 2);
            String combineDelimiter = defaultDelimiter.getDefaultDelimiter()
                    .substring(0, defaultDelimiter.getDefaultDelimiter().length() - 1)
                    + customDelimiter.getCustomDelimiter() + "]";
            String[] stringNumbers = input.split(combineDelimiter);


        }




    }
}