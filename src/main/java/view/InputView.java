package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readbuffer(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void validateInput(String input){
        if(input == null || input.equals("")){
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }
}
