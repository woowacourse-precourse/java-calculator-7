package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = add(input);
        System.out.println("결과 : " + result);

    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        input = input.replace("\\n","\n");

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            // 정규식 수정: 커스텀 구분자는 여러 글자일 수 있음
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.find()) {
                delimiter = matcher.group(1); // 커스텀 구분자 설정
                input = matcher.group(2); // 숫자 문자열 추출
            } else {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
        }

        // 구분자로 숫자 분리
        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);

            if(num < 0){
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += Integer.parseInt(number); // 각 숫자를 합산
        }

        return sum;
    }
}
