package calculator;

import java.util.ArrayList;
import java.util.List;

public class SeparatorProcessor {

    private final List<Character> separatorList;

    public SeparatorProcessor(Character... separator){
        separatorList = new ArrayList<>();
        for(Character c : separator){
            separatorList.add(c);
        }
    }

    public String[] split(String str){
        return str.split(getRegex());
    }

    public void addSeparator(Character c){
        separatorList.add(c);
    }

    private String getRegex(){
        StringBuilder regex = new StringBuilder();

        regex.append("[");
        for(char c : separatorList){
            regex.append(c);
        }
        regex.append("]");

        return regex.toString();
    }
}
