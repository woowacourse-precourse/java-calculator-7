package calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    private Set<String> separateSet = new HashSet<>();

    public Calculator(){
        separateSet.add(",");
        separateSet.add(":");
    }

    public int sumNumbers(String numbers){
        String[] splitNumbers = numbers.split(separateSet.toString());

        int sum = 0;
        for (String num : splitNumbers) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}

