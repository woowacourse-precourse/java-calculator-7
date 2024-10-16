package calculator;

import java.util.ArrayList;
import java.util.List;

public class SeparationProcessor {

    private final List<Character> separationList;

    public SeparationProcessor(Character... separations){
        separationList = new ArrayList<>();
        for(Character c : separations){
            separationList.add(c);
        }
    }

    public String[] split(String str){
        return str.split(getRegex());
    }

    public void addSeparation(Character c){
        separationList.add(c);
    }

    private String getRegex(){
        StringBuilder regex = new StringBuilder();

        regex.append("[");
        for(char c : separationList){
            regex.append(c);
        }
        regex.append("]");

        return regex.toString();
    }
}
