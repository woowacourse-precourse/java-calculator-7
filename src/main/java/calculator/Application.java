package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newSep = str;

        String[] sep = str.split("[,:]");
        for( int i = 0; i < sep.length; i++ ) {
            System.out.println(sep[i]);
        }

    }
}