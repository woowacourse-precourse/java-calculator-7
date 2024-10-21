package calculator;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input=readLine();
        int sum=calculateSum(input);
        System.out.println("결과 : "+sum);
    }
    private static int calculateSum(String input){
        if(input.isEmpty()) return 0;
        String[] numbers;
        if(input.startsWith("/")){
            int delimiterIndex=input.indexOf("n");
            if (delimiterIndex == -1||delimiterIndex==2) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            String custom=input.substring(2,delimiterIndex-1);
            input=input.substring(delimiterIndex+1);
            custom = custom.replaceAll("[{}()\\[\\].?*+|^$]", "\\\\$0");
            numbers=input.split("[,:]"+"|"+custom);
        }else{
            numbers=input.split("[,:]");
        }
        return sumNumbers(numbers);
    }
    private static int sumNumbers(String[] numbers) {
        int sum=0;
        for (String num : numbers) {
            if (!num.trim().isEmpty()) {
                try {
                    sum += Integer.parseInt(num.trim());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 값: " + num);
                }
            }
        }
        return sum;
    }
}
