package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String getString(){
        msgPrint();
        return stringInput();
    }
    private void msgPrint(){
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    private String stringInput(){
        String str = null;
        try {
            str = Console.readLine();
        } catch (IllegalArgumentException e){
            System.out.print("잘못된 값을 입력하였습니다.");
        }
        return str;
    }
}
