package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private static final IOHandler ioHandler = new IOHandler();

    public static void run() {

        String userInput = ioHandler.getUserInput();
        long sum = calculateUserInput(userInput);
        ioHandler.printCalculatedOutput(sum);

        Console.close();
    }

    private static long calculateUserInput(String userInput) {

        long sum = 0;

        if (isNothing(userInput)) {
            return sum;
        }

        if (isDefaultSeparator(userInput)) {
            if (userInput.contains(",")) {
                String[] nums = userInput.trim().split("[,:]");
                for (String num : nums) {
                    if (Long.parseLong(num) < 0) {
                        throw new IllegalArgumentException("양수로 구성된 문자열을 입력해 주세요.");
                    }
                    sum += Long.parseLong(num);
                }
            }
            return sum;
        }

        if (isCustomSeparator(userInput)) {
            String separator = userInput.substring(userInput.indexOf("//") + 2,
                    userInput.indexOf("\\n"));
            String[] nums = userInput.substring(userInput.indexOf("\\n") + 2).split(separator);
            for (String num : nums) {
                if (Long.parseLong(num) < 0) {
                    throw new IllegalArgumentException("양수로 구성된 문자열을 입력해 주세요.");
                }
                sum += Long.parseLong(num);
            }
            return sum;
        }

        throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해 주세요.");
    }

    private static boolean isCustomSeparator(String userInput) {
        return userInput.contains("//") && userInput.contains("\\n");
    }

    private static boolean isDefaultSeparator(String userInput) {
        return userInput.contains(",") || userInput.contains(":");
    }

    private static boolean isNothing(String userInput) {
        return userInput.isEmpty();
    }
}
