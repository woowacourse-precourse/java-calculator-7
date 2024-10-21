package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        try { // 입력
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 빈 문자열 처리
            if (input == null || input.isEmpty()) {
                System.out.println("결과 : 0");
                return;
            }


            // 기본 구분자 처리
            String delimiter = ",|:";

            // 커스텀 구분자 처리
            if (input.startsWith("//")) {
                Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
                if (matcher.find()) {
                    delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 추출
                    input = matcher.group(2); // 커스텀 구분자 이후 숫자 문자열
                } else {
                    throw new IllegalArgumentException();
                }
            }

            String[] numbers = input.split(delimiter);
            int sum = 0;
            for (String number : numbers) {
                sum += Integer.parseInt(number.trim());
            }
            // 결과 출력
            System.out.println("결과 : " + input);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 프로그램 종료
            System.err.println(e);
        }
    }
}
