package calculator;

import camp.nextstep.edu.missionutils.Console;

//View
public class View {
	//User의 입력값을 받아옴
	public String getUserInput() {
		System.out.println("덧셈할 문자열을 입력해 주세요");
		String inputData = Console.readLine();
		return inputData;
	}
	
	public void displayResult(int answer) {
		System.out.println("결과 : " + answer);
	}
}