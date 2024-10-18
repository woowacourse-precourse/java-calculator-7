package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();  // read input
            int result;
            result = calculate(input);
            System.out.println("결과 : " + result);
    }

    public static int calculate(String input) {
        String[] tokens = input.split("[,:]"); // basic separator : , :
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token); //string to int

            sum += number;
        }

        return sum;
    }
}
