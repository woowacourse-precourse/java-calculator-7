package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;

public class IOController {
    public static String input(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    public static void printAnswer(BigInteger answer){
        System.out.println("결과 : " + answer);
    }
}
