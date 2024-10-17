package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("문자열 입력 : ");
        String inputString = Console.readLine();
        System.out.printf("입력받은 문자열 : %s\n", inputString);
    }
}
