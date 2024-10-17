package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("잘못된 형식의 입력값입니다.");
        }

        int result = add(input);

        System.out.println("결과 : " + result);
    }

    public static String[] delimiterSeparation(String input){
        String delimiter = "[^0-9-]+";
        String numbers = input;

        if(input.startsWith("//")){
            int index = input.indexOf("\n");
            if (index > 0) {
                delimiter = Pattern.quote(input.substring(2, index));
                numbers = input.substring(index + 1);
            }
        }
        return numbers.split(delimiter);
    }

    public static int add(String input){
        String[] numbers = delimiterSeparation(input);

        int sum = 0;
        for(String number : numbers){
            if(!number.isEmpty()){
                int num = Integer.parseInt(number);

                if(num<0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다. "+num);
                }
                sum+=num;
            }
        }
        return sum;
    }
}
