package calculator;

import camp.nextstep.edu.missionutils.Console;



public class Application {
    public static void main(String[] args) {

        // 1. Console 를 사용하여 입력을 받고 null 및 공백 체크
        String input = Console.readLine();
        Console.close();

        if (input == null || input.isEmpty()) {
            System.out.println("sum: 0");
            return;
        }

    }
}
