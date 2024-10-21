package calculator.domain;

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

    public List<Character> getParams() {
        return params;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void addNum(int num) {
        nums.add(num);
    }

    public void addParam(Character param){
        params.add(param);
    }
}
