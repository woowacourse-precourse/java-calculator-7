package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.input.DefaultInput;
import calculator.input.CustomInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = 0;
        // "//"로 시작하면 Custom 구분자
        if(input.startsWith("//")){
            String deli = input.substring(2); // "//" 제거해서 구분자만 받기
            String input_nums = Console.readLine();
            CustomInput customInput = new CustomInput();
            result = customInput.customParseSum(deli, input_nums);
        }
        else{
            DefaultInput defaultInput = new DefaultInput();
            result = defaultInput.defaultParseSum(input);
        }

        System.out.println("결과 : " + result);
    }
}
