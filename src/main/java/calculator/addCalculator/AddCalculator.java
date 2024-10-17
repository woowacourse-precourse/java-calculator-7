package calculator.addCalculator;

import calculator.stringSplitter.StringSplitter;
import camp.nextstep.edu.missionutils.Console;

public class AddCalculator {
    public int calculateSum(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            int num = Integer.parseInt(number.trim());
            if(num < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

}
