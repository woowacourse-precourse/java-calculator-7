package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input_str = Console.readLine();

        String delimiter = ",|:";

        if(input_str.startsWith("//")){
            String[] split_str = input_str.split("\n");
            if(split_str.length ==2){
                String customDelimiter = split_str[0].substring(2);
                delimiter += "|" + customDelimiter;
                input_str = split_str[1];
            }else {
                throw new IllegalArgumentException("커스텀 구분자는 //와 \\n사이에 존재해야합니다. ");
            }
        }

        String[] str_nums = input_str.split(delimiter);
        for(String str_num : str_nums){
            try{
                int int_num = Integer.parseInt(str_num.trim());
                if (int_num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형태입니다.");
            }
        }
    }
}
