package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input_str = Console.readLine();

        String delimiter = ",|:";

        CustomDelimeterParser.parse(input_str, delimiter);

        int sum = 0;
        String[] str_nums = input_str.split(delimiter);
        for(String str_num : str_nums){
            try{
                int int_num = Integer.parseInt(str_num.trim());
                if (int_num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum+=int_num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형태입니다.");
            }
        }

        System.out.println("결과 : "+sum);
    }
}
