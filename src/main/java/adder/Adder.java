package adder;

import java.util.ArrayList;

public class Adder {

    public Integer addNumbers(ArrayList<Integer> numbers) {
        int result = 0;

        for(int number: numbers){
            result += number;
        }

        return result;
    }

}
