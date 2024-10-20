package calculator.view;

public class Output {

	public void printInitialMessage() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
	}

	public void printAnswerMessage(int answer) {
		System.out.println("결과 : " + answer);
	}
}
