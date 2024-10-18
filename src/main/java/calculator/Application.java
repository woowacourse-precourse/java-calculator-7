package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        String[] nums;
        String delimiter = ",:";

        if(str.matches("//.\\\\n.+")){
            delimiter = String.valueOf(str.charAt(2));
            str = str.substring(5);
        }
        nums = str.split("["+ delimiter + "]");

        int sum = 0;
        for (String num : nums) {
            try{
                int i = Integer.parseInt(num);
                if (i < 0) {
                    throw new IllegalArgumentException();
                }
                sum += i;
            } catch(NumberFormatException e){
                throw new IllegalArgumentException();
            }
        }

        System.out.println("결과 : " + sum);
    }
}
