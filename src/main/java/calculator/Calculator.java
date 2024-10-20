package calculator;

import java.util.List;

public class Calculator {

    private Long addElements(List<Long> elements) {
        Long sum = 0L;
        for (Long element: elements) {
            sum += element;
        }
        return sum;
    }
}
