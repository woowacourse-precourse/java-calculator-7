package calculator.service;
import calculator.domain.Numbers;
import java.util.LinkedList;

public class CalculateService {
    public Long calculateSum(Numbers numbers) {
        Long sumResult = 0L;
        LinkedList<Integer> numberList = numbers.getNumbersList();
        for (Integer integer : numberList) {
            sumResult += integer;
        }
        return sumResult;
    }
}
