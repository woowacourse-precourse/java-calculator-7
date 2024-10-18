package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean checkDefaultDelimterFormat(String inputString) {
        String rex = "^[0-9]+([,:]\\d*)*$";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(inputString);

        return matcher.find();
    }

    public static boolean checkCustomDelimiterFormat(String inputString) {
        String rex =  "^//[\\D ]\\\\n.*$";
        Pattern p = Pattern.compile(rex);
        Matcher matcher = p.matcher(inputString);

        return matcher.find();
    }
    public static void checkNagativeInt(int part) {
        if (part < 0) {
            throw new IllegalArgumentException("음수값은 덧셈 할 수 없습니다.");
        }
    }
    public static Boolean checkRemainStringFormat(String remainingInput, String customDelimiter) {
        String rex = "^[0-9]+([" + customDelimiter + "]\\d*)*$";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(remainingInput);

        return matcher.find();
    }
}
