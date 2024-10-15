package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // //@\n1@2,3:4
        // //@\n1@2,"":4
        // //@\n1@2, :4

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        DefaultDelimiter defaultDelimiter = new DefaultDelimiter();

        String input = Console.readLine();

        if (isCustom(input)) {
            int customDelimiterEndIndex = input.indexOf("\\n");
            CustomDelimiter customDelimiter = new CustomDelimiter(input.substring(2, customDelimiterEndIndex));
            input = input.substring(customDelimiterEndIndex + 2);
            String combineDelimiter = defaultDelimiter.getDefaultDelimiter()
                    .substring(0, defaultDelimiter.getDefaultDelimiter().length() - 1)
                    + customDelimiter.getCustomDelimiter() + "]";
            String[] stringNumbers = input.split(combineDelimiter);

            int sum = 0;
            for (String stringNumber : stringNumbers) {
                if (stringNumber.equals("\"\"")) {
                    sum += 0;
                }

                if (!stringNumber.equals("\"\"")) {
                    sum += Integer.parseInt(stringNumber);
                }
            }
            System.out.println("결과 : " + sum);
        }

        if (!isCustom(input)) {
            String defaultRegex = defaultDelimiter.getDefaultDelimiter();
            String[] stringNumbers = input.split(defaultRegex);
            int sum = 0;
            for (String stringNumber : stringNumbers) {
                sum += Integer.parseInt(stringNumber);
            }
            System.out.println("결과 : " + sum);
        }


    }

    private static boolean isCustom(String input) {
        return input.startsWith("//");
    }
}