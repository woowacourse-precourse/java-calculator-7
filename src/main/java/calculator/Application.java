package calculator;

import java.util.*;

public class Application {
    private TextNumber number;
    private int sum;

    public Application(){
        this.number=new TextNumber();
    }

    public String changingNumber(String insert) {

        return number.calculatingNumberPlus(insert);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application change = new Application();
        System.out.println("뎃셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String insert = sc.nextLine();
        String result=change.changingNumber(insert);
        System.out.println("결과: "+result);

    }
}