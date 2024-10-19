package calculator;

import java.util.Scanner;

public class Application {

	Scanner scan = new Scanner(System.in);
	int sum = 0;
	String[] customNumbers;

	void mymain() {
		System.out.println("숫자를 입력하세요.");
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
			sum += Integer.parseInt(s);
		}
		System.out.printf("합 : %d", sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application a = new Application();
		a.mymain();
	}

}
