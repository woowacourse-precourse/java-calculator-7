package calculator;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
       System.out.println("문자열을 입력해 주세요");
        String input = Console.readLine();
            int result = plus(input);
            System.out.printf("result: %d%n", result);
    }

    public static int plus(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String separator = "[,:]";  
         String[] answer = input.split(separator);
         for (int i = 0; i < answer.length; i++) {
             String number = answer[i];
                 if (Integer.parseInt(number) > 0) {
                      sum += Integer.parseInt(number);
                  } 
         }
         return sum;

    }
}
