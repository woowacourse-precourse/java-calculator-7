package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static String[] arr;

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            checkInput(input);
            int result = getSum(parseInteger());
            System.out.println("결과 : " + result);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        Console.close();
    }

    public static void checkInput(String input){
        if (input != null && !input.isEmpty())
            seperator(input);
        else
            throw new IllegalArgumentException();
    }

    public static void seperator(String input){
        if(input.contains("//") && input.contains("\\n")){
            int i = input.indexOf("//");
            String s = "" + input.charAt(i+2);
            input = input.replace("//"+s+"\\n", "");
            arr = input.split(s);
        } else {
            arr = input.split(",|:");
        }
    }

    public static int[] parseInteger(){
        int[] numbers = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
                numbers[i] = Integer.parseInt(arr[i].replaceAll(" ", ""));
        }

        return numbers;
    }

    public static int getSum(int[] numbers){
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }

        return sum;
    }
}
