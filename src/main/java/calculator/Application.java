package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        //IllegalArgumentException 예외처리를 위한 try~catch 구문
        try{
            String str = Console.readLine();

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("애플리케이션 종료");
        }
    }
}
