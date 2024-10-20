package calculator.calculate;

import java.util.ArrayList;

public class Calculate {
    public static int Makesum(ArrayList<Integer> numlist){
        int sum = 0;
        for(int i = 0; i < numlist.size(); i++){
            sum += numlist.get(i);
        }
        return sum;
    }
}
