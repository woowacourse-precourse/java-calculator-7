package calculator;

import camp.nextstep.edu.missionutils.Console;

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
           // 출력
           System.out.println("결과 : " + input);
       } catch (IllegalArgumentException e) {
            // 예외 발생 시 프로그램 종료
            System.err.println(e);
        }
    }
}
