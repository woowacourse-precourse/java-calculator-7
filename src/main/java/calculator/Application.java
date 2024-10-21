package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try{
            String input = Console.readLine();
            int sum;
            if (nullCheck(input)){
                sum = 0;
            } else {
                sum = addNumbers(isPositiveNum(stringSplit(input)));
            }//if end
            System.out.println("결과 : " + sum);
        } catch(java.util.NoSuchElementException e){
            System.out.println("결과 : 0");
        }//try end
    }//main() end

    private static int addNumbers(int[] numbers){
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }//for end
        return sum;
    }//addNumbers() end

    private static int[] isPositiveNum(String[] inputs) {
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            int num = Integer.parseInt(inputs[i]);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력하실 수 없습니다");
            }//if end
            numbers[i] = num;
        }//for end
        return numbers;
    }//isPositiveNum() end

    private static String[] stringSplit(String input){
        if(input.startsWith("//")){
            int separEndIndex = input.indexOf("\\n");
            if(separEndIndex != -1){
                String customSeparator = input.substring(2, separEndIndex);
                String numbers = input.substring(separEndIndex+2);
                return numbers.split(customSeparator);
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다. \\n을 포함하여 다시 입력해주세요");
            }//if end
        } else {
            return input.split(",|:");
        }//if end
    }//stringSplit() end

    private static boolean nullCheck(String input) {
        return input.isEmpty() || input.trim().isEmpty();
    }//nullCheck() end
}//class end
