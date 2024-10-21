package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String result = "";

        if (input.startsWith("//")) {
            String sep = input.substring(2, input.indexOf("\\n"));
            String[] str = input.substring(input.indexOf("\\n") + 2).split("[,:" + sep + "]");
            result =  String.join(", ", str);
        } else {
            String[] str = input.split(",|:");
            result =  String.join(", ", str);
        }

        System.out.println("결과 : " + result);
    }


}