package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String value = Console.readLine();
        System.out.println("결과 : " + Calculator.execute(value));
    }


}
