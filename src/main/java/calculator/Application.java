package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        ArrayList<Character> delimiters = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        delimiters.add(',');
        delimiters.add(':');

        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = br.readLine();

            if (input.isEmpty()){
                System.out.println(result);
                return;
            }

            boolean prev = true;
            int number = 0;
            int pos = 0;
            boolean flag = false;

            if (input.charAt(0) == '/'){
                flag = true;
                if (input.charAt(1) == '/'){
                    if (input.charAt(3) == '\\') {
                        if (input.charAt(4) == 'n') {
                            delimiters.add(input.charAt(2));
                            pos = 5;
                            flag = false;
                        }
                    }
                }
            }

            if (flag){
                throw new IllegalArgumentException();
            }


        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
}
