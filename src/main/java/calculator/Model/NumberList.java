package calculator.Model;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumberList {
    private static ArrayList<Integer> numberList = new ArrayList<>();

    public boolean isEmpty() {
        return !this.numberList.isEmpty();
    }
}
