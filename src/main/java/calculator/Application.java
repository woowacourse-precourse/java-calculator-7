package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private static final String HINT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void main(String[] args) {
        System.out.println(HINT_MESSAGE);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = readInput(bufferedReader);

        int result = StringAdditionCalculator.calc(input);

        end(bufferedReader, result);
    }

    private static String readInput(BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력을 받는 중 오류가 발생했습니다.", e);
        }
    }

    private static void end(BufferedReader bufferedReader, int result) {
        try {
            System.out.println(RESULT_MESSAGE + result);
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("BufferedReader를 종료하던 도중 오류가 발생했습니다.", e);
        }
    }
}
