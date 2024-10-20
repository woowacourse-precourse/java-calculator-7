package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {

    List<Character> params;
    List<Integer> nums;

    public Separator() {
        params = new ArrayList<>();
        params.add(',');
        params.add(':');
        nums = new ArrayList<>();
    }

}
