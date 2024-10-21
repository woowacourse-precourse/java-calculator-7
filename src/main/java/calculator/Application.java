package calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input;
        String sep = "";
        String str = "";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        String[] input_split = input.split("");
        String[] str_num = input.split(",|:");

        if (input_split[0].equals("/")) {
            for (int i = 2; i < input_split.length; i++) {
                if (input_split[0].equals("/") && input_split[1].equals("/")) {
                    if (input_split[i].equals("\\") && input_split[i + 1].equals("n")) {
                        break;
                    }
                    sep += input_split[i];
                }
            }

            for (int i = 4 + sep.length(); i < input.length(); i++) {
                str = str + input_split[i];
            }
        }
    }
}
