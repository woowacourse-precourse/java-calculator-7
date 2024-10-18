package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String string = Console.readLine();
        if (string.isEmpty()) {
            System.out.println("결과 : 0");
            Console.close();
            return;
        }
        System.out.println("결과 : " + string);
        Console.close();
    }
}
