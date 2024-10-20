package exceptHandler;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class ExceptHandler {
    public static void detectContentForamt(String regex, String content) {
        if (!Pattern.matches(regex, content)) {
            throw new IllegalArgumentException("잘못된 구분자 입력");
        }
    }

    public static void detectCustomSeparatorFormat(String prefix, String suffix) {
        if (!prefix.equals("//") || !suffix.equals("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자의 생성 형식에 맞지 않음");
        }
    }

    public static void detectNegativeValueException(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("음수가 입력되었음");
        }
    }
}
