package calculator;

import java.util.ArrayList;

public class Calculate {
    int sum = 0;
    int Makesum(ArrayList<Integer> numlist){
        for(int i = 0; i < numlist.size(); i++){
            sum += numlist.get(i);
        }
        return sum;
    }
}
