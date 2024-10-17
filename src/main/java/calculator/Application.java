package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();

        if (input.isEmpty()){
            System.out.println("0");
        }

        //validateCustomSep(input);
        //calculate();

    }
    // 올바른 입력형태 (ex. 11:22,33)
    // 커스텀 구분자 입력 가능
    private static int calculate(String input, String... customSep) {
        String delimeters = ",|:";
        if (customSep.length > 0) {
            delimeters += "|" + customSep[0];
        }
        String[] arr = input.split(delimeters);
        int sum = 0;
        for (String s : arr){
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
        return sum;
    }

    private static boolean validateCustomSep(String input){
        // 정규식으로 커스텀 구분자 사용을 탐지
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);

        return matcher.find();
    }

    private static boolean containsInvalidCharacters(String input, String... customSep) {
        String regex = "0-9:.";

        if (customSep.length > 0) {

            String sep = customSep[0];
            if ("+*?[](){}|.^$".contains(sep)) {
                sep = "\\\\" + sep;  // 자바에서 \\는 정규식에서 \로 인식된다. 정규식에서 \\를 만들어야되니까 자바에서 \\\\를 추가하는 것
            }
            regex += sep;
        }

        regex = ".*[^" + regex + "].*";
        return input.matches(regex);
    }
    
    private static boolean startAndEndWithNumber(String input){
        return input.matches("^[0-9].*[0-9]$");
    }

}