package calculator.domain.mainprocess;

import java.util.List;

public class MainProcessor {

    public Integer calculate(List<String> numbers){
        Integer answer = 0;
        for(String num:numbers){
            answer+=Integer.parseInt(num);
        }
        return answer;
    }
}
