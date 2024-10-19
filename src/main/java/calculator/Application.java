package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiter = ",|:";
        String afterInput = input;
        Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
        if (input.startsWith("//")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);

                if (customDelimiter.matches("[a-zA-Z0-9]")) {
                    throw new IllegalArgumentException("특수 문자 아닌 문자");
                }
                delimiter = delimiter + "|" + Pattern.quote(customDelimiter);
                afterInput = matcher.group(2);
            }
            else
                throw new IllegalArgumentException("특수 구분자 형식이 아닙니다");
        }


        String[] tokens = afterInput.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            if(!token.isEmpty()){
                try {
                    int num = Integer.parseInt(token);
                    if (num < 0) {
                        throw new IllegalArgumentException("음수");
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 문자");
                }
            }
        }
        
        System.out.println("결과 : " + sum);
    }
}
