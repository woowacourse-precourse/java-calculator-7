package calculator;

import calculator.optionchecker.Optionchecker;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        Optionchecker op = new Optionchecker(input);

        op.optioncheck();

        if(op.getoption() == 1){
            System.out.println("기본 구분자");
        }
        else if(op.getoption() == 2){
            System.out.println("커스텀 구분자");
        }
        System.out.println("결과 : " + result);
    }
}
