package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static String inputString;
    private static String trimString;
    private static String[] stringArray;
    private static int total;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine();

        if(inputString.isEmpty()) total = 0;
        if(inputString.length() > 0) {
            stringArray = inputString.split(",|:");
            for (int i = 0; stringArray.length > i; i++) {
                total += Integer.parseInt(stringArray[i]);
            }
        }
        System.out.println(total);
    }
}

