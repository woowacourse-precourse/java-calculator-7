package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {


    }

    //1. 입력 받기
    private static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        //커스텀 구분자 사용 시 다음줄 입력받기.
        if (input.startsWith("//") && input.contains("\n")) {
            String nextLine=Console.readLine();
            input +="\n"+nextLine;
        }
        return input;
    }
}
