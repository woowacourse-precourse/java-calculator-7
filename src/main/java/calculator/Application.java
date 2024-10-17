package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = sumNumbers(extractNumbers(input));
        System.out.println("결과 : " + result);
    }

    public static String[] extractNumbers(String input){
        if(input == null || input.isEmpty()){
            return new String[]{"0"};
        }

        String delimiter = ",|;";

        if(input.startsWith("//")){
            int delimiterEndIndex = input.indexOf("\\n");

            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 2);
        }
        return splitNumbers(input, delimiter);
    }

    public static String[] splitNumbers(String input, String delimiter){
        return input.split(delimiter);
    }

    public static int sumNumbers(String[] numbers){
        int sum = 0;

        for (String number : numbers){
            if(!number.isEmpty()){
                int num = Integer.parseInt(number);
                sum += num;
            }
        }
        return sum;
    }
}
