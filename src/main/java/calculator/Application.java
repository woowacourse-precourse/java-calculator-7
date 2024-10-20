package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Character> delimiters = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        delimiters.add(',');
        delimiters.add(':');

        try{
            System.out.print("덧셈할 문자열을 입력해 주세요.");
            String input = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
