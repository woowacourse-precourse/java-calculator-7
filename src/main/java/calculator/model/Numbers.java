package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Numbers {
    private ArrayList<Integer> numbers;



    public Numbers(){
        this.numbers = new ArrayList<>();
    }

    public void add(int i){
        this.numbers.add(i);
    }

    public ArrayList<Integer> getNumbers(){
        return numbers;
    }
}
