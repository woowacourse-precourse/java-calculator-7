package calculator.view;

public class View {
	private static final String Input = "덧셈할 문자열을 입력해 주세요.";
	private static final String Output= "결과 : ";

	public static void inputMessage() {
		System.out.println(Input);
	}

	public static void outputMessage(int result) {
		System.out.println(Output + result);
	}


}
