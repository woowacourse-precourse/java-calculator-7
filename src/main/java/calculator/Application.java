package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 문자열을 입력하는 기능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = null;
        try {
            userInput = br.readLine();
        } catch (IOException e) {
            System.err.println("입력 오류: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("예기치 못한 오류: " + e.getMessage());
        }
    }
}
