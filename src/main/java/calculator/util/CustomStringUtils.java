package calculator.util;

public abstract class CustomStringUtils {
    public static void printStringLineFeed(String str) {
        System.out.print(str.concat("\n"));
    }

    public static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
