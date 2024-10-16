package calculator.domain.numCalculator;

import java.util.List;

public class NumCalculator {

    public Integer calculate(List<String> numbers){
        Integer asnwer = 0;
        for(String num:numbers){
            asnwer+=Integer.parseInt(num);
        }
        return asnwer;
    }
}
