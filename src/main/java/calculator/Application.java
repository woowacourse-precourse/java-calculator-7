package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input_str = Console.readLine();

        if(input_str.startsWith("//")){
            String[] split_str = input_str.split("\n");
            String customDelimiter = split_str[0].substring(2);
            input_str = split_str[1];
        }
    }
}
