package calculator.service;

import calculator.model.Numbers;
import calculator.model.Separator;
import java.util.ArrayList;
import java.util.Arrays;

public class Service {
    Numbers numbers;
    Separator separator;
    public void saveNumbersSeparator(String input){
        separator = new Separator(",:");
        numbers = new Numbers();

        if(input.startsWith("//")){
            int end = input.indexOf("\\n");
            String newSeparator = input.substring(2, end);
            separator.addSeparator(newSeparator);
            input = input.substring(end+2);
            System.out.println(input);
        }

        String[] s = input.split(separator.getSeparators());
        for (String i : s){
            int n = Integer.parseInt(i);
            numbers.add(n);
        }
    }

    public int getSum(){
        int sum = 0;
        ArrayList<Integer> nums = numbers.getNumbers();
        for (int i : nums){
            sum+=i;
        }
        return sum;
    }
}