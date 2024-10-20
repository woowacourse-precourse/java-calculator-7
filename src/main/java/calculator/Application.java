package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class StringParser {
    String user_input;

    public StringParser() {
    }

    //문자열 입력 받는 메서드(getUserInput)
    public String getUserInput() throws IllegalArgumentException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        try {
            user_input = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력값이 없습니다. 다시 입력해주세요.");
        }

        return user_input;
    }
}