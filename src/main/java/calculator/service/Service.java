package calculator.service;

import calculator.model.Numbers;
import calculator.model.Separator;
import calculator.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;

public class Service {

    public Separator setSeparator(String input){
        return new Separator(input);
    }

    public void addSeparator(Separator separator, String input){
        separator.addSeparator(input);
    }

    public Numbers setNumbers(ArrayList<Integer> nums){
        Numbers numbers = new Numbers();
        for (int i : nums){
            numbers.add(i);
        }
        return numbers;
    }
}