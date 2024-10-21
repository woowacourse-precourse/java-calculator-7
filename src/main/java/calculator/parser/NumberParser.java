package calculator.parser;


import calculator.exception.Exceptions;
import java.util.HashSet;
import java.util.Set;

public interface NumberParser extends Spliter, Finder {

    Set<String> delimiters = new HashSet<>();
    Class<? extends Number> numberClass = setNumberClass();

    static Number parse(String v) {
        Class<? extends Number> numberClass = setNumberClass();
        try {
            if (numberClass.equals(Double.class)) {
                return Double.valueOf(v);
            } else {
                return Integer.valueOf(v);
            }
        } catch (NumberFormatException e) {
            throw Exceptions.onlyNumberInput(); // think:유효성 검증을 하는 validator 클래스를 만들었는데, 여기서 예외를 던지고 있는 게 아쉽다.
        }
    }

    private static Class<? extends Number> setNumberClass() {
        if (delimiters.contains(".")) {
            return Integer.class;
        } else {
            return Double.class;
        }
    }
}
