package calculator;

import java.util.Scanner;

public class Application {

	Scanner scan = new Scanner(System.in);
	int sum = 0;
	String[] customNumbers;

	void mymain() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input = scan.next();
		if (input.contains("//")) {
			int length = input.length();
			customNumbers = new String[length];
			for (int i = 0; i < length; i++) {
				customNumbers[i] = input.substring(i, i + 1);
			}
			String custom = customNumbers[2];
			String newinput = "";
			for (int i = 5; i < length; i++) {
				newinput += customNumbers[i];
			}
			doCalc(newinput, custom);
		} else
			doCalc(input, null);
	}

	void doCalc(String input, String custom) {
		String[] numbers = input.split("[,:" + custom + "]");
		for (String s : numbers) {
			if(Integer.parseInt(s)<0){
				throw new IllegalArgumentException("음수가 입력되었습니다.");
			}

			sum += Integer.parseInt(s);
		}
		System.out.printf("결과 : %d", sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application a = new Application();
		a.mymain();
	}

}
