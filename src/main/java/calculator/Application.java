package calculator;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	System.out.println("문자열을 입력해 주세요");
        String input = Console.readLine();
        try {
            int result = plus(input);
            System.out.printf("result: %d%n", result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int plus(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String separator = ""; 
        if(String.valueOf(input.charAt(1)).equals(",")) {
        	separator = ",";
        }else if(String.valueOf(input.charAt(1)).equals(":")) {
        	separator = ":";
        }
        if(input.startsWith("//")) {
        	separator = input.substring(2, input.indexOf("\\n"));
        	input = input.substring(input.indexOf("\\n")+2);
        }

        
        String[] answer = input.split(separator);
        for (int i = 0; i < answer.length; i++) {
            String number = answer[i];
            try {
            	 if (Integer.parseInt(number) > 0) {
                     sum += Integer.parseInt(number);
                 } else {
                     throw new IllegalArgumentException("잘못된 입력값이 있습니다: " + number);
                 }
             } catch (NumberFormatException e) {
                 throw new IllegalArgumentException("잘못된 입력값이 있습니다: " + number);
             }
        }
        return sum;
    }
}
