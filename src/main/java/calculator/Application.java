package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	String input = Console.readLine();
    	
        String delimiter = ",|:";
        
        if (input.startsWith("//")) {
            int customDelimiter = input.indexOf("\\n");

            delimiter = input.substring(2, customDelimiter);
            input = input.substring(customDelimiter + 2);
        }

        String[] numbers = input.split(delimiter);
        
        int sum = 0;
        
        for (String number : numbers) {       
            int num = Integer.parseInt(number);
            
            sum += num;
            } 
            
        }

        System.out.println("결과 : " + sum);
}