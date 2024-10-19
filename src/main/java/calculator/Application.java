package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            if(input.isEmpty()) {
                System.out.println("결과 : " + 0);
                return;
            }

            String delimiter = "[,;]";

            if(input.contains("//")) {
                Pattern pattern = Pattern.compile("//(.*?)\\\\n");
                Matcher matcher = pattern.matcher(input);
                StringBuilder customDelimiter = new StringBuilder("[,;");

                int count = 0;

                while(matcher.find()) {
                    customDelimiter.append(matcher.group(), 2, matcher.group().length()-2);
                    count += matcher.group().length();
                }

                customDelimiter.append("]");
                delimiter = customDelimiter.toString();
                input = input.substring(count);
            }

            System.out.println("구분자 = " + delimiter);

            String[] inputSplits = input.split(delimiter);
            int result = 0;

            for (String s : inputSplits) {
                try{
                    int number = Integer.parseInt(s);
                    if(number < 0) {
                        throw new IllegalArgumentException("마이너스 입력");
                    }
                    result += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 값 입력");
                }
            }

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력을 하였습니다.");
            System.out.println(e.getMessage());
        }
    }
}
