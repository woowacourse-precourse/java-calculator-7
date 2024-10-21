package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    static List<String> store;
    static List<Integer> integerList;

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        // 입력값 null 검사
        try {
            isNull(input);
        } catch (IllegalArgumentException e) {
            return;
        }

        // 공백 지우기
        input = removeSpace(input);

        store = new ArrayList<>();
        store.add(",");
        store.add(":");

        makeCustomDelimiter(input);

        input = delimiterToSpace(input);

        String[] strList = input.split(" ");
        integerList = new ArrayList<>();

        try {
            strToInt(strList);
        } catch (IllegalArgumentException e) {
            return;
        }

        Integer sum = 0;

        for (Integer integer : integerList) {
            sum += integer;
        }

        System.out.println("결과 : " + sum);

    }

    public static void isNull(String input) {

        if (input == null) {
            throw new IllegalArgumentException("입력값은 null입니다.");
        }

    }

    public static String removeSpace(String input) {

        input = input.replaceAll(" ", "");
        input = input.replaceAll("\\p{Z}", "");

        return input;
    }

    public static void makeCustomDelimiter(String input) {

        String pattern = "//.*?\\\\n";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            String deli = matcher.group();
            store.add(deli);
            deli = deli.replace("//","");
            deli = deli.replace("\\n", "");
            store.add(deli);
        }

    }

    public static String delimiterToSpace(String input) {

        for (String s : store) {
            input = input.replaceAll(Pattern.quote(s), " ");
        }

        input = input.trim();

        return input;
    }

    public static void strToInt(String[] strList) {

        for (String s : strList) {
            Integer integer;
            try {
                integer = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
            }

            if (integer < 0) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
            }

            integerList.add(integer);
        }

    }


}
