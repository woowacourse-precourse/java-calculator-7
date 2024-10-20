package calculator;

import input.Input;
import input.InputFactory;

public class Application {
    public static void main(String[] args) {
    	Input input = InputFactory.newInput();
    	System.out.println("덧셈할 문자열을 입력해 주세요.");
    	System.out.println("결과 : " + input.inputStr());
    }
}
