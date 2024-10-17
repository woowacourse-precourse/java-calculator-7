package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final StringAdd stringAdd;

    public Calculator(){
        this.stringAdd = new StringAdd();
    }

    public void start(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        int result = stringAdd.add(inputStr);
        end(result);
    }

    private void end(int result){
        System.out.println("결과 : " + result);
    }

}
