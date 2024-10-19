package calculator;

import java.util.Scanner;

public class Calculator {
    /**
     * 문자열을 입력받아 반환하는 함수.
     *
     * @return 입력받은 문자열
     */
    public String input(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
