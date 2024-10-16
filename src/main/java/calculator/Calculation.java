package calculator;

import java.util.List;

public class Calculation {
    List<Integer> numberlist;
    int result;

    public Calculation(List<Integer> numberlist) {
        this.numberlist = numberlist;
        result = 0;
    }

    public int Calculate() {
        for(int i = 0; i < numberlist.size(); i++) {
            result += numberlist.get(i);
        }
        return result;
    }
}