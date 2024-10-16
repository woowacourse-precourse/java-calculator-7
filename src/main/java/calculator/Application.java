package calculator;

import java.util.HashMap;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static Set<String> seperators;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. "," ";" 구분자 추가
        init();


    }

    private static void init() {
        seperators = new HashSet<>();
        seperators.add(",");
        seperators.add(";");
    }
}
