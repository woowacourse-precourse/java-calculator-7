package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private static final IOHandler ioHandler = new IOHandler();
    private static final String DEFAULT_SEPARATOR = "[,:]";

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

        if (hasDefaultSeparator(userInput)) {
            String[] nums = userInput.split(DEFAULT_SEPARATOR);
            sum = calculateListSum(nums, sum);
            return sum;
        }

        if (hasCustomSeparator(userInput)) {
            String customSeparator = findSeparator(userInput);
            String[] nums = getSeparatorRemovedSubstring(userInput).split(customSeparator);
            sum = calculateListSum(nums, sum);
            return sum;
        }

        notHaveSeparator(userInput);
        sum += Long.parseLong(userInput);
        return sum;
    }

    private static long calculateListSum(String[] nums, long sum) {
        for (String num : nums) {
            if (Long.parseLong(num) < 0) {
                throw new IllegalArgumentException("양수로 구성된 문자열을 입력해 주세요.");
            }
            sum += Long.parseLong(num);
        }
        return sum;
    }

    private static String findSeparator(String userInput) {
        return userInput.substring(userInput.indexOf("//") + 2,
                userInput.indexOf("\\n"));
    }

    private static String getSeparatorRemovedSubstring(String userInput) {
        return userInput.substring(userInput.indexOf("\\n") + 2);
    }

    private static boolean isNothing(String userInput) {
        return userInput.isEmpty();
    }

    private static boolean hasDefaultSeparator(String userInput) {
        return userInput.contains(",") || userInput.contains(":");
    }

    private static boolean hasCustomSeparator(String userInput) {
        return userInput.contains("//") && userInput.contains("\\n");
    }

    private static void notHaveSeparator(String userInput) {
        if (!userInput.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("구분자를 지정해 주세요");
        }
    }
}
