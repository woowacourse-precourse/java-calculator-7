package calculator;

public class GetSepException {
    // 커스텀 구분자를 지정하지 않은 경우
    public static boolean isNotOriginSep(String str) {
        str = str.replace(",", "");
        str = str.replace(":", "");

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    // 커스텀 구분자를 지정한 경우
    public static boolean isNotCustomSep(String str, String sep) {
        str = str.replace(sep, "");

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }
}
