package calculator;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("덧셈할 문자열을 입력해 주세요.\n");
		try {
			String input = reader.readLine();
			Calculator.calculate(input);
		} catch (IOException e) {
			throw new IllegalArgumentException("입력 오류" + e.getMessage());
		}
	}
}


