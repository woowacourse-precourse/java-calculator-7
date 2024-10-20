package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 입력 데이터 읽기
//        System.out.println("input : " + input); // 입력 데이터 확인

        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {   // 입력 받은 문자열을 구분자를 기준으로 숫자로 분리하여 더함
        if (input == null || input.isEmpty()) { // input 데이터가 없거나, 비어있으면 0으로 반환
            return 0;
        }

        String[] tokens;
        String delimiter = ",|:";  // 기본 구분자
        Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);  // 정규표현식으로 커스텀 구분자 찾기

        if (matcher.find()) {
            delimiter += "|" + matcher.group(1);  // 기본 구분자에 커스텀 구분자 추가
            input = matcher.group(2);      // 실제 숫자 부분
        }

        tokens = input.split(delimiter);   // 입력 문자열을 구분자를 기준으로 분리

//        for(String token : tokens) {  // 배열에 담긴 값 확인
//            System.out.println(token);
//        }

        return sumTokens(tokens);          // 분리된 문자열을 숫자로 변환하여 더함
    }

    private static int sumTokens(String[] tokens) { // 분리된 문자열 배열의 숫자값들을 정수형으로 변환한 다음 더함
        int sum = 0;
        for (String token : tokens) {
            int number = toPositiveNumber(token.trim());    // 문자열 숫자를 정수형으로 형변환
            sum += number;  // 형변환된 숫자들을 더함
        }
        return sum;
    }

    private static int toPositiveNumber(String token) { // 문자열 숫자를 정수형으로 형변환
        int number = Integer.parseInt(token);   // 문자형을 정수형으로 형변환
        return number;
    }
}
