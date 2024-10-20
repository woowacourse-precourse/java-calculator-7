package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 사용자에게 문자열 입력받기
        System.out.println("덧셈 할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 구분자 확인
        String separator = getSeparator(input);
    }

    // 구분자 확인 메소드
    public static String getSeparator(String input){

        if(input.startsWith("//")){
            int separatorIndex = input.indexOf("\\n");
            if(separatorIndex != -1){
                return input.substring(2, separatorIndex);
            }
        }

        return "[,:]";
    }
}
