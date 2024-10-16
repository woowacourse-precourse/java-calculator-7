package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static String inputString;
    private static int total;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine();

        if(inputString.isEmpty()) total = 0;

        System.out.println(total);
    }
}

