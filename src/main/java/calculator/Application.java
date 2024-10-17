package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
//        System.out.println("//(.*?)\\n");
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        // TODO 커스텀 구분자 추출하고 -> 분리기능에 추출한 구분자 추가하기
        // 입력받은 // 와 \n 의 사이의 구분자 값 추출하기
        String defaultDelimiter = ",|:";
        String[] splitInputNumber;
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String inputDelimiter = matcher.group(1);
            input = matcher.replaceFirst("");
            String delimiter = defaultDelimiter + "|" + inputDelimiter;
            splitInputNumber = input.split(delimiter);
        } else {
            splitInputNumber = input.split(defaultDelimiter);
        }

        int result = 0;
        for (String number : splitInputNumber) {
            result += Integer.parseInt(number);
        }

        System.out.println("결과 : " + result);
    }

}
