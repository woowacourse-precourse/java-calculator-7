package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static final String SYSTEM_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String getUserInput() {
        System.out.println(SYSTEM_INPUT_MESSAGE);
        String userInput = Console.readLine();
        if (userInput.trim().isEmpty()) {
            return "0";
        }
        validateUserInput(userInput);
            return userInput;
    }

    public static void validateUserInput(String userInput) {

        if (userInput.startsWith("//")) {
            int customSeparatorEndIndex = userInput.indexOf("\\n");
            if (customSeparatorEndIndex != -1) {
                char customSeparator = userInput.charAt(2);
                String trimmedInput = userInput.substring(customSeparatorEndIndex + 2).trim();
                String[] numbers = trimmedInput.split("[,:" + customSeparator + "]");
                for(String number : numbers) {
                    if(number.startsWith("-")){
                        throw new IllegalArgumentException("양수만 입력해주세요.");
                    } else {
                        try {
                            Double.parseDouble(number);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("잘못된 문자를 입력했습니다.");
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("잘못된 문자를 입력했습니다.");
            }
        } else {
            String[] numbers = userInput.split("[,:]");
            for(String number : numbers) {
                if(number.startsWith("-")){
                    throw new IllegalArgumentException("양수만 입력해주세요.");
                } else {
                    try {
                        Double.parseDouble(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("잘못된 문자를 입력했습니다.");
                    }
                }
            }
        }
    }
}