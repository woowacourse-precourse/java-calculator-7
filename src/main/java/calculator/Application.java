package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputValidator inputValidator = new InputValidator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try{
            if (!inputValidator.isValid(input)){
                throw new IllegalArgumentException("잘못된 입력입니다. " + input);
            }
            System.out.println("유효한 입력입니다: " + input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


    }
}
