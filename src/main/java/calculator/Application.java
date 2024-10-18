package calculator;

import input.Input;
import input.InputImpl;

public class Application {
    public static void main(String[] args) {
    	// TODO: 프로그램 구현
    	Input input = new InputImpl();
    	
    	// 기능
    	// 1. 문자열 입력받기
    	System.out.println("덧셈할 문자열을 입력해 주세요.");
    	input.input();
    	
    	// 2. 구분자(쉼표(,) 또는 콜론(:))를 기준으로 숫자 분리
    	// 3. 커스텀 구분자(문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자)를 기준으로 숫자 분리
    	// 4. 모든 숫자 더하기
    }
}
