package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    //구분자 초기 설정
    static String delimiter = ",|:";
    static int result = 0;

    public static void main(String[] args){
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine().replace("\\n", "\n");
        try {
            String calText = FirstPattern(input);
            String[] split = calText.split(delimiter);
            result = Sum(split);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }


    }

    private static String FirstPattern(String input) throws IllegalArgumentException{
        String calText = input;
        if (calText.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(calText);
            if (matcher.matches()) {
                delimiter += "|" + Pattern.quote(matcher.group(1));
                calText = matcher.group(2);
            } else {
                throw new IllegalArgumentException("구분자 오류입니다.");
            }
        }

        return calText;
    }

    private static int Sum(String[] split) throws IllegalArgumentException {
        int result = 0;
        for (String s : split) {
            try {
                int num = Integer.parseInt(s);
                if (num <= 0) {
                    throw new IllegalArgumentException("음수 또는 0은 입력할 수 없습니다: " + num);
                }
                result += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 문자로 바꿀 수 없습니다. " + s);
            }
        }
        return result;
    }

}
