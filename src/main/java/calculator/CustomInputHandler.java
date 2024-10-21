package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomInputHandler {
    static List<Character> evaluateCustomInput(String input) {
        String regex = "^//(.*?)\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String capturedContent = matcher.group(1).trim();
            List<Character> charList = new ArrayList<>();
            for (char ch : capturedContent.toCharArray()) {
                if (!charList.contains(ch)) {
                    charList.add(ch);
                }
            }
            return charList;
        }
        return new ArrayList<>();

    }

    static String removeCustomInput(String input) {
        String regex = "^//.*?\\\\n";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.replaceFirst("");
        }
        return input;
    }
}
