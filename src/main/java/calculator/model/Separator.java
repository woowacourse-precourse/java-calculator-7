package calculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 구분자를 관리하는 Separator. 기본적으로 {@code ','}와 {@code ':'}를 구분자로 포함하며, 추가적인 구분자를 동적으로 추가하거나 제거할 수 있다. 구분자 리스트를 반환하는 메소드도
 * 포함한다.
 */
public class Separator {
    /**
     * 구분자를 저장하는 리스트이다. 기본 구분자로 ','와 ':'가 포함된다.
     */
    private static ArrayList<Character> separators = new ArrayList<>();

    static {
        separators.add(',');
        separators.add(':');
    }

    private Separator() {
    }

    /**
     * 구분자를 리스트에 추가
     */
    public static boolean addSeparator(Character separator) {
        return separators.add(separator);
    }

    /**
     * 구분자를 리스트에서 제거함.
     */
    public static boolean removeSeparator(Character separator) {
        return separators.remove(separator);
    }

    /**
     * 구분자 리스트를 반환함.
     */
    public static List<Character> getSeparators() {
        return separators;
    }
}

