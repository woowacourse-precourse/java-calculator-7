package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {

    private static List<Character> seperatorList = new ArrayList<>();

    static {
        seperatorList.add(',');
        seperatorList.add(';');
    }
}
