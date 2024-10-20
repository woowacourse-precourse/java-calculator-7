package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] lines = input.split("\\\\n");

        String separator = getSeparator(lines[0]);
    }

    private static String getSeparator(String header) {
        if (header.startsWith("//")) {
            return header.substring(2);
        }

        return "[,:]";
    }
}
