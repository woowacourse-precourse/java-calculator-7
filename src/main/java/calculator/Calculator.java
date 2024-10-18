package calculator;

import java.util.List;

/**
 * 숫자 리스트를 모두 더하는 역할
 */
public class Calculator {

    /**
     * 숫자 리스트를 모두 더한다.
     *
     * @param numberList 숫자 리스트
     * @return 덧셈 결과
     */
    public int add(List<Integer> numberList) {
        int result = 0;
        for (int number : numberList) {
            result += number;
        }
        return result;
    }
}
