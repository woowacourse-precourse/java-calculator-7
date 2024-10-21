package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static String[] arr;
    public static int[] numbers;

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        checkInput(input);
        int result = getSum();
        System.out.println("결과 : " + result);

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

        parseInteger();
    }

    public static void parseInteger() {
        numbers = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            numbers[i] = Integer.parseInt(arr[i].replaceAll(" ", ""));
            if(numbers[i] < 0) throw new IllegalArgumentException();
        }
    }

    public static int getSum(){
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }

        return sum;
    }
}
