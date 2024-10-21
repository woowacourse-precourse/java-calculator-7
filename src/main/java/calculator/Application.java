package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 문구
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 문자열 입력 받기
        String input = Console.readLine();
        
        // 숫자 추출
        // 기본 구분자와 숫자 구분하여 숫자만 문자열 배열에 넣기
        String[] numbers = input.split(",|:");
            // 테스트 위해 구분된 숫자 출력
            /*
            for(String test : numbers){
                System.out.println(test);
            }
            */

        // 더하기
        int sum = 0; // 더한 값 저장할 변수

        for (String number : numbers){
            int num = Integer.parseInt(number); // 타입을 문자에서 숫자로 변환
            sum += num; // 덧셈
        }

        //결과 출력
        System.out.println("결과 : " + sum);


    }
}
