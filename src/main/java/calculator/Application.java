package calculator;

import java.io.*;

public class Application {
    public static void main(String[] args) {
        String inputString = getInputString();
    }

    private static String getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            return input;
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력값이 입력되었습니다.");
        }
    }
}
