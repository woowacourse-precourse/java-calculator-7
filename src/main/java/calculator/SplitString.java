package calculator;

public class SplitString {
    String[] splitString(String str, String separators) {
        if (separators.length() == 5) {
            String checkString = str.substring(5);
            return checkString.split(separators);
        }
        return str.split(separators);
    }
}