package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number.");
        String input = sc.nextLine();

        String number[] = input.split("[, ;]");

        System.out.println("number : " + Arrays.toString(number));
    }
}
