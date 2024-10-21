package calculator;

import java.util.List;

//4.추출한 숫자 더하기
public class AddNumber {
    List<Integer> extract;

    AddNumber(List<Integer> extract){
        this.extract = extract;
    }

    int add(){
        int sum = 0;
        for(int i : extract){
            sum += i;
        }
        return sum;
    }
}
