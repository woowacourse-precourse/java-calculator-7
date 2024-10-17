package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input_str = Console.readLine();

        if(input_str.startsWith("//")){
            String[] split_str = input_str.split("\n");
            if(split_str.length ==2){
                String customDelimiter = split_str[0].substring(2);
                input_str = split_str[1];
            }else {
                throw new IllegalArgumentException("커스텀 구분자는 //와 \\n사이에 존재해야합니다. ");
            }
        }
    }
}
