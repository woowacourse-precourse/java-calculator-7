package calculator;

import java.util.ArrayList;
import java.util.List;

public class Adder {
    List<Integer> numberlist;
    int result;

    public Adder() {
        numberlist = new ArrayList<Integer>();
        result = 0;
    }

    public int add(List<Integer> numberlist) {
        for(int i = 0; i < numberlist.size(); i++) {
            result += numberlist.get(i);
        }
        return result;
    }
}
