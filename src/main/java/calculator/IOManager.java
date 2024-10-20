package calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class IOManager {

	public static String getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("덧셈할 문자열을 입력해 주세요.\n");
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new IllegalArgumentException("입력 오류: " + e.getMessage());
		}
	}

	public static void printOutput(int result) {
		System.out.println("결과 : " + result);
	}
}
