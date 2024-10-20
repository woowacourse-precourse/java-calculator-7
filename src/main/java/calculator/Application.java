package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//사용자가 잘못 입력한 경우 IllegalArgumentException 을 발생시킨 후 프로그램 종료
//잘못된 입력 : 공백, 문자, 특수문자, 음수, 소숫점 숫자
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //api를 이용한 사용자 출력받기
        System.out.println("덧셈할 문자열을 입력해주세요.");
        calculator();
    }

    public static String calculator() {
        String example = Console.readLine();

        //입력값이 빈값인 경우
        if (example.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력");
        }

        //일반 구분자 설정
        String[] original = example.split(",|;");

        //초기화
        int Result = 0;

        //1. 커스텀 구분자 처리
        if (example.startsWith("//")) {
            //커스텀 구분자 판별 정규식
            Pattern pattern = Pattern.compile("//(.*?)\\\\n(.*)");
            //입력값과 비교
            Matcher matcher = pattern.matcher(example);
            if (matcher.find()) {
                String customSpeartor = matcher.group(1);
                String customNumber = matcher.group(2);
                String[] custom = customNumber.split(Pattern.quote(customSpeartor));
                //덧셈
                for (int i = 0; i < custom.length; i++) {
                    try {
                        int number = Integer.parseInt(custom[i]);
                        //음수처리
                        if (Integer.parseInt(custom[i]) < 0) {
                            throw new IllegalArgumentException();
                        }
                        Result = number + Result;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("잘못된 입력");
                    }
                }
                System.out.println("결과 : " + Result);
            }
            //2. 일반 구분자 처리
        } else {
            //덧셈
            for (int i = 0; i < original.length; i++) {
                try {
                    int number = Integer.parseInt(original[i]);
                    //음수처리
                    if (Integer.parseInt(original[i]) < 0) {
                        throw new IllegalArgumentException();
                    }
                    Result = number + Result;
                } catch (Exception e) {
                    throw new IllegalArgumentException("잘못된 입력");
                }
            }
            System.out.println("결과 : " + Result);
        }
        return null;
    }
}
