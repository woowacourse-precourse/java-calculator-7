package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String seperator = DecideSeparatorInString(input);
        String[] arr = DevideStringToSeparator(input, seperator);
        System.out.println(String.join(" ", arr));
        try {
            if(!isCorrectInput(arr, seperator)) {
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Console.close();
            return;
        }

        Console.close();
    }

    private static String DecideSeparatorInString(String string) {
        String value = "";
        int indexDoubleSlash = string.indexOf("//");
        int indexNewline = string.indexOf("\\n");
        int isComma = string.indexOf(",");
        int isColon = string.indexOf(":");
        if(indexDoubleSlash != -1 && indexNewline != -1) {
            value += string.substring(indexDoubleSlash+2, indexNewline);
        }
        if(isComma != -1) {
            value += ",";
        }
        if(isColon != -1) {
            value += ":";
        }
        return value;
    }

    private static String[] DevideStringToSeparator(String string, String separator) {
        int indexNewline = string.indexOf("\\n");
        if(indexNewline != -1) {
            string = string.substring(indexNewline + 2);
        }
        if (separator.isEmpty()) {
            return new String[]{string};
        }
        return string.split(String.format("[%s]",separator));
    }

    private static boolean isCorrectInput(String[] input, String separator) {
        String temp = separator.replaceAll("[,:]+", "");
        if (temp.length() >= 2) {
            return false;
        }
        for (int i = 0; i < input.length; i++) {
            if (!input[i].matches("^[0-9]*$")) {
                return false;
            }
        }
        return true;
    }
}
