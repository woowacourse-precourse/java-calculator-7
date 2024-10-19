package calculator.service;
import calculator.domain.Numbers;
import java.util.LinkedList;

public class CalculateService {
    public int calculateSum(Numbers numbers) {
        int sumResult =0;
        LinkedList<Integer> numberList = numbers.getNumbersList();
        for(int i=0;i<numberList.size();i++) {
            sumResult += numberList.get(i);
        }
        return sumResult;
    }
}
