package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 기본(쉼표, 콜론) 구분자로 각 숫자의 합을 반환하는 기능
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ans = 0;

        String[] split = str.split("[,:]");

        for (String s : split) {
            ans += Integer.parseInt(s);
        }

        System.out.println("결과 : " + ans);

    }
}
