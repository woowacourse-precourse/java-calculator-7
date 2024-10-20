package calculator.Model;

import java.util.ArrayList;
import java.util.List;

class StringManagement {
    String Delimiter = ",:";

    public void customDelimiter(String input){
        int start = input.indexOf("//");
        int last = input.indexOf("\n");

        if(start != -1 && last != -1){
            Delimiter += input.substring(start+1,last);
        }
        else if(start != -1 || last != -1){
            System.out.println("구분자를 분리할 수 없습니다.");
        }
    }

    public List<String> splitString(String input){
        ArrayList<String> splitNum = new ArrayList<>();
        customDelimiter(input);
        String[] splitInput = input.split(Delimiter);
        for(int i=0; i<splitInput.length; i++)
            splitNum.add(splitInput[i]);
        return splitNum;
    }

    public ArrayList<Double> strToInt(String input) {
        ArrayList<Double> num = new ArrayList<>();
        ArrayList<String> splitNum = new ArrayList<>(splitString(input));

        for(int i=0; i<splitString(input).size(); i++) {
            num.add(Double.parseDouble(splitNum.get(i)));
            if (num.get(i) < 0){
                System.out.println("음수는 입력할 수 없습니다.");
            }
        }
        return num;
    }
}