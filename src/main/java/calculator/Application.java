package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {

    static StringBuilder sb;
    static String str;
    static String regex;
    static String[] numbers;
    static long result;

    public static void main(String[] args) {
        sb = new StringBuilder();
        regex = "[,:]";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        str = Console.readLine();
        sb.append("결과 : ");

        if (checkCustom(str)) {
            addCustom(regex, str);
        }

        if (str.equals("")) {
            sb.append(0);
        } else {
            numbers = str.split(regex);
            result = addSum(numbers);
            sb.append(result);
        }
        System.out.print(sb);
    }

    private static boolean checkCustom(String str) {
        return str.startsWith("//") && str.indexOf("\n") > 2;
    }

    private static void addCustom(String regex, String str) {
        int newlineIndex = str.indexOf("\\n");
        String customRegex = str.substring(2, newlineIndex);
        Application.regex = "[,:]" + Pattern.quote(customRegex);
        Application.str = str.substring(newlineIndex + 2);
    }

}