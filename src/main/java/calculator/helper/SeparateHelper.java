package calculator.helper;

import java.util.*;

public class SeparateHelper {
    public final static Set<Character> BASIC_SEPARATOR = new HashSet<>(Arrays.asList(':', ','));

    public static boolean isSeparator(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public static String findSeparator(String input) {
        int startIndex = 2;
        int endIndex = input.lastIndexOf("\\n");
        return input.substring(startIndex, endIndex);
    }

    public static String splitString(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int index = input.lastIndexOf("\\n");
            return input.substring(index + 2);
        }
        return input;
    }
    //새로 받음
    public static Set<Character> addStringToCharSet(String separator) {
        Set<Character> newSeparators = new HashSet<>(BASIC_SEPARATOR);
        for (int i = 0; i < separator.length(); i++) {
            newSeparators.add(separator.charAt(i));
        }
        return newSeparators;
    }

}
