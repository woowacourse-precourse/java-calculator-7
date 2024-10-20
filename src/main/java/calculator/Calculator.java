package calculator;

import java.util.List;

public class Calculator {

    // 덧셈 처리 및 결과 반환 기능
    public Integer sum(List<Integer> parsedNumberList) {

        Integer result = 0;

        for (int i = 0; i < parsedNumberList.size(); i++) {
            result += parsedNumberList.get(i);
        }

        return result;
    }

}
