package calculator;

import java.util.ArrayList;
import java.util.List;

class Func{
    Input input = new Input();

    public List<String> split(){
        ArrayList<String> splitNum = new ArrayList<>();
        String[] splitInput = input.userInput().split(",");
        for(int i=0; i<splitInput.length; i++)
            splitNum.add(splitInput[i]);
        return splitNum;
    }
    public ArrayList<Integer> strToInt() {
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<String> splitNum = new ArrayList<>(split());

        for(int i=0; i<split().size(); i++) {
            num.add(Integer.parseInt(splitNum.get(i)));
        }
        return num;
    }
}