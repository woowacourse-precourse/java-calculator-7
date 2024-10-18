package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        String[] input_integer = input.split(",|:");

        int sum = 0;

        for(String integer : input_integer){
            sum += Integer.parseInt(integer.trim());
        }

        System.out.println("결과 : " + sum);
    }
}
