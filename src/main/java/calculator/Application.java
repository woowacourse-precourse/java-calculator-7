package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String user_input = Console.readLine();

        int answer = 0;

        if (user_input.isEmpty()) {
            answer = 0;
        }



        System.out.println("결과 : " + answer);
    }

}
