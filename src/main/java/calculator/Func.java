package calculator;

import java.util.ArrayList;
import java.util.List;

class Func{
    public List<String> split(Input input){
        ArrayList<String> splitNum = new ArrayList<>();
        String[] splitInput = input.userInput().split(",");
        for(int i=0; i<splitInput.length; i++)
            splitNum.add(splitInput[i]);
        return splitNum;
    }
    public ArrayList<Integer> strToInt(Input input) {
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<String> splitNum = new ArrayList<>(split(input));

        for(int i=0; i<split(input).size(); i++) {
            num.add(Integer.parseInt(splitNum.get(i)));
        }
        return num;
    }
}