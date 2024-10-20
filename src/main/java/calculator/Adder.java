package calculator;

import java.util.ArrayList;
import java.util.List;

public class Adder {
    List<Integer> extractedNumList = new ArrayList<Integer>();

    Adder(List<Integer> numList) {
        this.extractedNumList = numList;
    }

    // 추출된 숫자 리스트의 합계 반환
    public int getSum() {
        return extractedNumList.stream().mapToInt(Integer::intValue).sum();
    }
}
