package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	String input = Console.readLine();
        String delimiter = ",|:";
        
        if (input.startsWith("//")) {
            int customDelimiter = input.indexOf("\\n");
            if (customDelimiter == -1) {

                throw new IllegalArgumentException();
            }
            delimiter = input.substring(2, customDelimiter);
            input = input.substring(customDelimiter + 2);
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException();
            }
            try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("결과 : " + sum);}
}