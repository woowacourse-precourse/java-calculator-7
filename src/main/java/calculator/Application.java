package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

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
            System.out.println("결과 : " + result);
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("BufferedReader를 종료하던 도중 오류가 발생했습니다.", e);
        }
    }
}
