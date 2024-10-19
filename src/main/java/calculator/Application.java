package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        if (input.charAt(0) == '/') {
            char delimiter = input.charAt(2);
            String regex = "[,:" + delimiter + "]";
            String[] splits = input.substring(5).split(regex);
            System.out.println(Arrays.toString(splits));
        } else {
            String[] splits = input.split("[,:]");
            System.out.println(Arrays.toString(splits));
        }


    }
}
