package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String delimiter = ",|:";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] s = input.split("\\\\n");
        String customDelimiter = "";
        if(s[0].startsWith("//")){
            customDelimiter = s[0].substring(2);
        }else{
            throw new IllegalArgumentException("커스텀 구분자를 사용하려면 //로 시작해야 합니다.");
        }
        String totalDelimiter = delimiter+"|"+customDelimiter;
        String[] inputNumbers = s[1].split(totalDelimiter);
        



    }
}
