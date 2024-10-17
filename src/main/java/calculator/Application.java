package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input1 = scanner.next();

        String[] tokens = input1.split("[,:]");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("숫자X " + token);
            }
        }

        for (int i : numbers) {
            System.out.println(i);
        }
    }
}
