package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserView {
    public static String readInputString() {
        return readLine();
    }

    public static void printStartCalculator(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printResult(int result){
        System.out.printf("결과 : %d", result);
    }
}