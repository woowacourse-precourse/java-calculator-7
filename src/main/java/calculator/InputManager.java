package calculator;

import camp.nextstep.edu.missionutils.Console;
class EmptyException extends Exception{}

public class InputManager {
    public String getString(){
        printMsg();
        return stringInput();
    }

    private void printMsg(){
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    private String stringInput(){
        String str = null;
        try {
            str = Console.readLine();
            if (str.isEmpty()) {
                throw new EmptyException();
            }
        } catch (IllegalArgumentException e){
            System.out.print("잘못된 값을 입력하였습니다.");
        } catch (EmptyException e){
            System.out.print(0);
            Application.flag = true;
        }
        return str;
    }
}
