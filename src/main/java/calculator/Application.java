package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        String delimiter = ",|:";

        String[] input_integer = input.split(delimiter);

        int sum = 0;

        for(String integer : input_integer){
            if(integer.trim().isEmpty()) continue;

            try{
                int number = Integer.parseInt(integer.trim());
                sum += number;
            }
            catch (IllegalArgumentException e) {
                System.out.println("invalid");
                return;
            }

        }

        System.out.println("결과 : " + sum);
    }


}
