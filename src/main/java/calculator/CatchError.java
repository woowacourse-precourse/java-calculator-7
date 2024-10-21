package calculator;

public class CatchError {

    public String[] catchError(String[] str) {
        for (String s : str) {
            if (s == null || s.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력입니다. (null 또는 빈 문자열)");
            }
            for (char c : s.trim().toCharArray()) {
                if (c < '0' || c > '9') {
                    throw new IllegalArgumentException("잘못된 입력입니다. 숫자만 입력해야 합니다: " + s);
                }
            }
        }
        return str;
    }



    public static String catchError(String str) {
        if (!str.startsWith("//") && str.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 입력입니다. 구분자가 없음");
        } else if (str.startsWith("//") && !str.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 입력입니다. 잘못된 구분자 형식");
        }
        return str;
    }

    public String nullCheck(String str) {
        if (str == null) {
            throw new IllegalArgumentException("잘못된 입력입니다. (null 값)");
        }
        return str;
    }
}