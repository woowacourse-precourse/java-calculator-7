package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int sum = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String msg = Console.readLine();

        // 기본 구분자는 ; 혹은 ,로 설정
        String seperator= ";|,";
        if (!msg.equals("")) {
            // 문자열이 공백이 아닌 경우에만 탐색
            if (msg.length() >= 5) {
                // 커스텀 구분자를 사용하려면 문자열 길이가 최소 5 이상이어야됨
                String temp = msg.substring(0, 5);
                if (temp.startsWith("//") && temp.endsWith("\\n")) {
                    // //으로 시작하고 \n으로 끝나는 경우에는 구분자를 변경
                    seperator = temp.substring(2, 3);
                    msg = msg.substring(5, msg.length());
                }
            }
            String[] numbers = msg.split(seperator);
            try {
                for (String number : numbers) {
                    int temp = Integer.parseInt(number);
                    if (temp > 0) {
                        sum += temp;
                    } else {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException();
            }
        }
        System.out.println("결과 : " + sum);
    }
}
