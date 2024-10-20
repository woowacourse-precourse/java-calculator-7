package calculator.service;

import java.util.List;

public class AdderService {
    private AdderService() {
    }

    public static Integer sumAll(List<Integer> operands) {
        int sum = 0;
        for(Integer operand : operands) {
            sum += operand;
        }
        return sum;
    }
}
