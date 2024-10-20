package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자 입력을 받음
        System.out.println(input);
        int sum = 0;
        if(!(input.isEmpty())){
            String[] nums = input.split("[:,,]");
            for (String num : nums){
                sum += Integer.parseInt(num);
            }
        }
        System.out.println(sum);
    }
}