package calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String REGEX = "[,:]";
        System.out.println("덧셈할 문자열을 입력해주세요");
        Scanner sc = new Scanner(System.in);

        String user_input = sc.nextLine();

        sc.close();

        float result = 0;
        String[] a_arr = user_input.split(REGEX);
        for (String s : a_arr) {
            float number = Float.parseFloat(s);
            result += Float.parseFloat(s);
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.printf("결과 : %s", df.format(result));
    }
}
