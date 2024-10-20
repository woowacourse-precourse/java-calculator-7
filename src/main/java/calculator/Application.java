package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Calculator calculator = new Calculator();
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = reader.readLine();
            int result = calculator.add(input);
            System.out.println("결과: " + result);
        } catch (IOException e) {
            System.out.println("입력을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}