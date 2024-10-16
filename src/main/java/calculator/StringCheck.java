package calculator;

public class StringCheck {
    String checkSeparator(String str) {
        String separator = ",|;";

        int startIndex = str.indexOf("//");
        int endIndex = str.indexOf("\\n");
        if (startIndex == 0 && endIndex == 3) {
            return separator + "|" + str.substring(startIndex + 2, endIndex);
        }
        return separator;
    }
}