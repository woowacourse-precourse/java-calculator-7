package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput input = new UserInput();
        String in = input.userInput();
        List<String> number = input.substringInput(in);
        int sum = 0;
        for(String num : number) {
            if(Integer.parseInt(num) < 0)
                throw new IllegalArgumentException();
            sum += Integer.parseInt(num);
        }

        System.out.println("결과 : " + sum);
    }
}
