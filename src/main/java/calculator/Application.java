package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            // 빈 문자열로 왔을 시 0 출력 후 종료
            if(input.isEmpty()) {
                System.out.println("결과 : " + 0);
                return;
            }

            String delimiter = "[,:]";

            // 커스텀 구분자가 있는지 확인
            if(input.contains("//")) {
                Pattern pattern = Pattern.compile("//(.*?)\\\\n");
                Matcher matcher = pattern.matcher(input);
                StringBuilder customDelimiters = new StringBuilder("[,:");

                int count = 0;

                // //와 \n로 이루어진 문자열이 있을 경우 그 사이의 커스텀 구분자 가져오기
                while(matcher.find()) {
                    customDelimiters.append(matcher.group(), 2, matcher.group().length()-2);
                    count += matcher.group().length();
                }

                customDelimiters.append("]");
                delimiter = customDelimiters.toString();
                input = input.substring(count);
            }

            // 현재 구분자들 알려주기
            System.out.println("구분자 = " + delimiter);

            String[] inputSplits = input.split(delimiter);
            int result = 0;

            // 구분자들로 나눈 숫자들을 더하기
            for (String s : inputSplits) {
                try{
                    int number = Integer.parseInt(s);

                    // 마이너스 입력 시 예외 처리
                    if(number < 0) {
                        throw new IllegalArgumentException("마이너스 입력");
                    }
                    result += number;

                    // 숫자가 아닌 문자를 사용할 경우 예외 처리
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 값 입력");
                }
            }

            // 결과 알리기
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "으로 인하여 애플리케이션 종료합니다.");
        }
    }
}
