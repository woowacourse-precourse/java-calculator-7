package calculator;

import java.util.*;

public class Adder {
    int result;

    public Adder() {
        result = 0;
    }

    public int add(List<Integer> numberlist) {
        for(int i = 0; i < numberlist.size(); i++) {
            result += numberlist.get(i);
        }
        return result;
    }
}
