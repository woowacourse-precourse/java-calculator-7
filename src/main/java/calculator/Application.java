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
        String[] numbers=input.split("[,:]");
        return sumNumbers(numbers);
    }

    private static int sumNumbers(String[] numbers) {
        int sum=0;
        for (String num : numbers) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }
}
