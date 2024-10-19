package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println(DecideSeparatorInString(input));
        Console.close();
    }

    private static String DecideSeparatorInString(String string) {
        String value = "";
        int indexDoubleSlash = string.indexOf("//");
        int indexNewline = string.indexOf("\\n");
        int isComma = string.indexOf(",");
        int isColon = string.indexOf(":");
        System.out.println("DoubleSlash"+indexDoubleSlash);
        System.out.println("NewLine"+indexNewline);
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
}
