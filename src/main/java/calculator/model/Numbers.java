package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Numbers {
    private ArrayList<Integer> numbers;

    public Numbers(int[] numbers){
        this.numbers = new ArrayList<>();
        for (int i : numbers) {
            this.numbers.add(i);
        }
    }

    public ArrayList<Integer> getNumbers(){
        return numbers;
    }
}
