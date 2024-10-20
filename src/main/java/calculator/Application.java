package calculator;

import java.util.*;

public class Application {
    private String insert;
    private int sum;

    public void changingNumber() {
        System.out.println("뎃셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        insert = sc.nextLine();
        TextNumber plus = new TextNumber();
        plus.calculatingNumberPlus(insert);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application change = new Application();
        change.changingNumber();
    }
}