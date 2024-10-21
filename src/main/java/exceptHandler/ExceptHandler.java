package exceptHandler;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class ExceptHandler {

    //커스텀 구분자로 등록되지 않은 문자열이 왔을 때 예외처리하기 위한 메서드
    public static void detectContentForamt(String regex, String content) {
        if (!Pattern.matches(regex, content)) {
            throw new IllegalArgumentException("잘못된 구분자 입력");
        }
    }

    //커스텀 구분자를 만드는 구문이 잘못되었을 때를 검사하는 메서드
    public static void detectCustomSeparatorFormat(String prefix, String suffix) {
        if (!prefix.equals("//") || !suffix.equals("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자의 생성 형식에 맞지 않음");
        }
    }

    //문제에서 입력된 조건이 아닌 음수가 나올 때 예외 처리를 위한 메서드
    public static void detectNegativeValueException(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("음수가 입력되었음");
        }
    }
}
