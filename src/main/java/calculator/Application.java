package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.inputString();
    }
}

class Input {
    public static String inputString() {
        System.out.println("Please enter the strings to add.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
