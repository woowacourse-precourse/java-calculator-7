package calculator;

import camp.nextstep.edu.missionutils.Console;

public class View {
    //Todo: 문자열 입력 및 출력
    public static String userInput() {
        return Console.readLine();
    }

    public static void output(int result) {
        System.out.println("결과 : " + result);
    }
}
