package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        String input;
        int result;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            input = Console.readLine();
        } catch (Exception e) { // empty string
            input = "";
        }

        result = calculate(input);
        System.out.println("결과 : " + result);
    }

    public static int calculate(String input) {
        //input = input.replace("\\n", "\n");
        String numbers = input;
        String delimiters = "[,:]"; //basic separators


        if (input.isEmpty()){
            return 0;
        }

        // custom delimiters
        if (input.startsWith("//")) {
            int idx = input.indexOf("\\n");
            System.out.println(idx);
            if (idx == -1) {
                throw new IllegalArgumentException(); // add custom delimiters error
            }
            String custom_delimiters = input.substring(2, idx);
            delimiters = "[,:|" + Pattern.quote(custom_delimiters) + "]";
            numbers = input.substring(idx + 2);
        }

        String[] tokens = numbers.split(delimiters);
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token); // string to int
            if (number < 0) {
                throw new IllegalArgumentException(); //negative int error
            }
            sum += number;
        }

        return sum;
    }
}
