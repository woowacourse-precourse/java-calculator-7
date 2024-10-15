package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String delimiter = "";
        String input = Console.readLine();

        // 문자열이 //로 시작하는지 확인
        if(input.startsWith("//")){
            // 커스텀하기위한 마지막이\n 이 끝나는 위치
            int delimiterEndIndex = input.indexOf("\\n");
            System.out.println(delimiterEndIndex);
            // //@\n
            // @
            delimiter = input.substring(2,delimiterEndIndex);
            // \n의 숫자들
            input = input.substring(delimiterEndIndex +2);
            System.out.println(delimiter);
        }





    }
}
