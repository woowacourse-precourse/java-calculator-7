package calculator.split;

public class StringSplit {
    public static String getFrontString(String string) {
        String[] split = string.split("\n");
        return split[0].substring(2);
    }

    public static String getBackString(String string) {
        String[] split = string.split("\n", 2);
        return split[1];
    }

    public static boolean validateFrontString(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("해당 문자열은 문자로만 이루어져야 합니다.");
            }
        }
        return true;
    }

    public static char[] getSeperatorArray(String string) {
        return string.toCharArray();
    }
}
