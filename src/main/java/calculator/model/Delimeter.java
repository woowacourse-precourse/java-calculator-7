package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Delimeter {
    private ArrayList<String> values = new ArrayList<String>(Arrays.asList(",", ":"));

    public Delimeter(){}

    public String setDelimeter(String input){

        if(input.startsWith("//")&& input.indexOf("\\n")==3){
            // //로 시작하고 문자 하나 오고, \n로 닫히는 경우 -> 사이에 있는 것은 Custom Delimeter
            String customDelimeter = Character.toString(input.charAt(2));
            values.add(customDelimeter);
            return input.replace("//"+customDelimeter+"\\n", "");
        }
        return input;
    }

    public ArrayList<String> getValues() {
        return values;
    }
}
