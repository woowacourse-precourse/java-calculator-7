package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 입력 데이터 읽기
//        System.out.println("input : " + input); // 입력 데이터 확인

        String[] tokens;
        String delimiter = ",|:";  // 기본 구분자

        tokens = input.split(delimiter);   // 입력 문자열을 구분자를 기준으로 분리

        for (String token : tokens) {   // 배열에 담긴 값 확인
            System.out.println(token);
        }
    }
}
